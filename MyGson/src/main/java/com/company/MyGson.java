package com.company;

import java.util.ArrayList;

public class MyGson {


    public String toJson(Object res) {
        if (res instanceof ArrayList) {
            return collectionTooJson(res);
        } else if (res instanceof Number) {
            return primitiveToJson(res);
        } else {
            return arrayToJson(checkAndConvertPrimitiveArray(res));
        }

    }


    private String collectionTooJson(Object res) {
        ArrayList<Object> temp = (ArrayList<Object>) res;
        StringBuilder json = new StringBuilder();
        json.append("[");

        for (Object indexOf : temp) {
            if (indexOf.getClass().isArray()) {
                json.append(arrayToJson(checkAndConvertPrimitiveArray(indexOf))).append(",");

            } else {
                json.append(primitiveToJson(indexOf)).append(",");
            }
        }
        json.setLength(json.length() - 1);
        json.append("]");


        return json.toString();
    }

    private String arrayToJson(Object res) {
        StringBuilder json = new StringBuilder();
        try {
            json.append("[");
            Object[] objects = (Object[]) res;
            for (Object obj : objects) {
                json.append(primitiveToJson(obj)).append(",");
            }
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }


        json.deleteCharAt(json.length() - 1);
        json.append("]");
        return json.toString();
    }


    private String primitiveToJson(Object res) {

        if (res instanceof String) {
            return "\"" + res + "\"";
        } else if (res instanceof Number) {
            return res.toString();
        }
        if (res instanceof Character) {
            return "\"" + res + "\"";
        } else if (res instanceof Boolean) {
            return "" + res;
        } else if (res instanceof String) {

            return res.toString();
        } else {
            return null;
        }
    }

    private Object checkAndConvertPrimitiveArray(Object res) {

        if (res instanceof int[]) {
            int[] temp = (int[]) res;
            Integer[] convertedArray = new Integer[temp.length];
            for (int i = 0; i < temp.length; i++) {
                convertedArray[i] = temp[i];
            }
            return convertedArray;
        } else if (res instanceof boolean[]) {
            boolean[] temp = (boolean[]) res;
            Boolean[] convertedArray = new Boolean[temp.length];
            for (int i = 0; i < temp.length; i++) {
                convertedArray[i] = temp[i];
            }
            return convertedArray;
        } else if (res instanceof char[]) {
            char[] temp = (char[]) res;
            Character[] convertedArray = new Character[temp.length];
            for (int i = 0; i < temp.length; i++) {
                convertedArray[i] = temp[i];
            }
            return convertedArray;
        } else if (res instanceof byte[]) {
            byte[] temp = (byte[]) res;
            Byte[] convertedArray = new Byte[temp.length];
            for (int i = 0; i < temp.length; i++) {
                convertedArray[i] = temp[i];
            }
            return convertedArray;
        } else if (res instanceof short[]) {
            short[] temp = (short[]) res;
            Short[] convertedArray = new Short[temp.length];
            for (int i = 0; i < temp.length; i++) {
                convertedArray[i] = temp[i];
            }
            return convertedArray;
        } else if (res instanceof long[]) {
            long[] temp = (long[]) res;
            Long[] convertedArray = new Long[temp.length];
            for (int i = 0; i < temp.length; i++) {
                convertedArray[i] = temp[i];
            }
            return convertedArray;
        } else if (res instanceof float[]) {
            float[] temp = (float[]) res;
            Float[] convertedArray = new Float[temp.length];
            for (int i = 0; i < temp.length; i++) {
                convertedArray[i] = temp[i];
            }
            return convertedArray;
        } else if (res instanceof double[]) {
            double[] temp = (double[]) res;
            Double[] convertedArray = new Double[temp.length];
            for (int i = 0; i < temp.length; i++) {
                convertedArray[i] = temp[i];
            }
            return convertedArray;
        } else {
            return res;
        }
    }
}


