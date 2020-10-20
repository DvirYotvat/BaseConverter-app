// Dvir Yotvat - MrRabbiT-coder

package com.example.baseconverter;

// logic class with only one method that convert decimal number (base 10) to all bases
// between base 2 to base 36
class BaseConverter {

    // the method that do the convert
    public static String convertFrom10(int num, int base) {

        String converted = "";

        while (num != 0) {
            converted = ((num % base > 9) ? (char) ('7' + num % base) + converted : num % base + converted);
            num /= base;
        }
        return converted;
    }
}
