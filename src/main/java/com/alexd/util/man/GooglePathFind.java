package com.alexd.util.man;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


    import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;

import com.google.common.collect.Maps;
import org.json.JSONException;
import org.json.JSONObject;




    public class GooglePathFind {


        public static double[] getCoor( String name) throws IOException, JSONException {
            final String baseUrl = "http://maps.googleapis.com/maps/api/geocode/json";// путь к Geocoding API по HTTP
            final Map<String, String> params = Maps.newHashMap();
            params.put("sensor", "false");// исходит ли запрос на геокодирование от устройства с датчиком местоположения
            params.put("address", "Россия, "+name);// адрес, который нужно геокодировать
            final String url = baseUrl + '?' + encodeParams(params);// генерируем путь с параметрами
            System.out.println(url);// Путь, что бы можно было посмотреть в браузере ответ службы
            final JSONObject response = JsonReader.read(url);// делаем запрос к вебсервису и получаем от него ответ
            // как правило наиболее подходящий ответ первый и данные о координатах можно получить по пути
            // //results[0]/geometry/location/lng и //results[0]/geometry/location/lat
            JSONObject location = null;
            try {
                  location = response.getJSONArray("results").getJSONObject(0);
            }
            catch (JSONException e)
            {
                return new double[]{-1,-1};
            }
            location = location.getJSONObject("geometry");
            location = location.getJSONObject("location");
            final double lng = location.getDouble("lng");// долгота
            final double lat = location.getDouble("lat");// широта
            double [] result = {lat ,lng};
            return result;
        }


        public static int[] getPath( String begin, String end) throws IOException, JSONException {
            final String baseUrl = "http://maps.googleapis.com/maps/api/directions/json";// путь к Geocoding API по
            // HTTP
            final Map<String, String> params = new HashMap<String, String>();
            params.put("sensor", "false");// указывает, исходит ли запрос на геокодирование от устройства с датчиком
            params.put("language", "ru");// язык данные на котором мы хотим получить
            params.put("mode", "driving");// способ перемещения, может быть driving, walking, bicycling

            params.put("origin", "Россия, "+ begin);// адрес или текстовое значение широты и
            // отправного пункта маршрута
            params.put("destination", "Россия, "+ end);// адрес или текстовое значение широты и
            // долготы
            // долготы конечного пункта маршрута
            final String url = baseUrl + '?' + encodeParams(params);// генерируем путь с параметрами
            System.out.println(url); // Можем проверить что вернет этот путь в браузере
            final JSONObject response = JsonReader.read(url);// делаем запрос к вебсервису и получаем от него ответ
            // как правило наиболее подходящий ответ первый и данные о координатах можно получить по пути
            // //results[0]/geometry/location/lng и //results[0]/geometry/location/lat
            JSONObject location = response.getJSONArray("routes").getJSONObject(0);
            location = location.getJSONArray("legs").getJSONObject(0);
            final int distance = location.getJSONObject("distance").getInt("value")/1000;
            final int duration = location.getJSONObject("duration").getInt("value")*1000;

            int [] result = {distance, duration};
            return result;
        }




        private static String encodeParams(final Map<String, String> params) {
            final String paramsUrl = Joiner.on('&').join(// получаем значение вида key1=value1&key2=value2...
                    Iterables.transform(params.entrySet(), new Function<Map.Entry<String, String>, String>() {


                        public String apply(final Map.Entry<String, String> input) {
                            try {
                                final StringBuffer buffer = new StringBuffer();
                                buffer.append(input.getKey());// получаем значение вида key=value
                                buffer.append('=');
                                buffer.append(URLEncoder.encode(input.getValue(), "utf-8"));// кодируем строку в соответствии со стандартом HTML 4.01
                                return buffer.toString();
                            } catch (final UnsupportedEncodingException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }));
            return paramsUrl;
        }





    }


    class JsonReader {

        private static String readAll(final Reader rd) throws IOException {
            final StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        }

        public static JSONObject read(final String url) throws IOException, JSONException {
            final InputStream is = new URL(url).openStream();
            try {
                final BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                final String jsonText = readAll(rd);
                final JSONObject json = new JSONObject(jsonText);
                return json;
            } finally {
                is.close();
            }
        }
    }

