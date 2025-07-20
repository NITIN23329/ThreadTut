package designPattern.structural;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// common interface for real and proxy class
interface WeatherService{
    String getWeather(String user, String city);
}
// real class
class RealWeatherService implements WeatherService{
    @Override
    public String getWeather(String user, String city) {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){}
        return "Weather for city: " + city+" is: 25°C";
    }
}
// authenitaction proxy
class AuthenicatedProxyWeatherService implements WeatherService{
    private WeatherService weatherService;
    private Set<String> autheticatedUsers = new HashSet<>();
    public AuthenicatedProxyWeatherService(WeatherService weatherService){
        this.weatherService = weatherService;
        autheticatedUsers.add("Nitin");
    }

    @Override
    public String getWeather(String user, String city) {
        if(autheticatedUsers.contains(user)){
            return weatherService.getWeather(user, city);
        }else {
            return "User: " + user + " is not authorized to access weather";
        }
    }
}
// cache proxy
class CachedProxyWeatherService implements WeatherService{
    private WeatherService weatherService;
    private Map<String, String> cache;
    public CachedProxyWeatherService(WeatherService weatherService){
        this.weatherService = weatherService;
        cache = new HashMap<>();
    }

    @Override
    public String getWeather(String user, String city) {
        String key = user + ":" + city;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        cache.put(key, weatherService.getWeather(user, city));
        return cache.get(key);
    }
}


public class ProxyExample {
    public static void main(String[] args) {
        WeatherService weatherService = new RealWeatherService();
        WeatherService proxyWeatherService = new AuthenicatedProxyWeatherService(weatherService);
        WeatherService proxyCachedService = new CachedProxyWeatherService(proxyWeatherService);

        System.out.println(proxyCachedService.getWeather("Ritik", "New Delhi"));

        System.out.println(proxyCachedService.getWeather("Nitin", "New Delhi"));
        System.out.println(proxyCachedService.getWeather("Nitin", "New Delhi"));


    }
}
