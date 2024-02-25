package ch16_network.openapi;

import org.json.simple.JSONArray;

public class DataCollector {

    public static void main(String[] args) throws Exception {

        JSONArray total = new JSONArray();

        for (int i = 1; i <= 47; i++){
            JSONArray items = OpenAPIMain.getMediList(i);
            total.addAll(items);
        }


        System.out.println(total.size());


    }
}
