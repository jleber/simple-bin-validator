package com.jleber.simple.bin.validator.enumeration;

import com.jleber.simple.bin.validator.model.CreditCardInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jleber on 06/06/16.
 */
public enum Bin {

        VISA(buildVisaBinList(), new CreditCardInfo("Visa","16","3")),

        MASTERCARD(buildMastercardBinList(), new CreditCardInfo("Mastercard","16","3")),

        AMEX(buildAmexBinList(), new CreditCardInfo("Amex","15","3")),

        DISCOVER(buildDiscoverBinList(), new CreditCardInfo("Discover","19","3")),

        DINERS(buildDinersBinList(), new CreditCardInfo("Diners","14","3")),

        ELO(buildEloList(),  new CreditCardInfo("Elo","16","3")),

        HIPERCARD(buildHiperCardBinList(), new CreditCardInfo("Hipercard","19","3"));

        private String[] cardBin;
        private CreditCardInfo creditCardInfo;

        Bin(String[] cardBin, CreditCardInfo creditCardInfo) {
            this.cardBin = cardBin;
            this.creditCardInfo = creditCardInfo;
        }

        private static final Map<String, CreditCardInfo> lookup = new HashMap<>(1);

        static {
            for(Bin brand : Bin.values()){
                for (String bin : brand.getCardBin()) {
                    if(!lookup.containsKey(bin)){
                        lookup.put(bin, brand.getCreditCardInfo());
                    }
                }
            }
        }

        private static String[] buildVisaBinList(){
            return new String[]{"4"};
        }

        private static String[] buildMastercardBinList(){
            return new String[]{"51","52","53","54","55"};
        }


        private static String[] buildAmexBinList(){
            return new String[]{"34","37"};
        }


        private static String[] buildDiscoverBinList(){
            return new String[]{"6"};
        }

        private static String[] buildDinersBinList(){
            return new String[]{"30","36","38"};
        }


        private static String[] buildEloList(){
            List<String> bins = new ArrayList<>(1);

            bins.add("401178");
            bins.add("401179");
            bins.add("438935");
            bins.add("431274");
            bins.add("451416");
            bins.add("457393");
            bins.add("457631");
            bins.add("457632");
            bins.add("504175");
            bins.addAll(buildBinInterval("506699-506778"));
            bins.addAll(buildBinInterval("509000-509999"));
            bins.add("627780");
            bins.add("636297");
            bins.add("636368");
            bins.addAll(buildBinInterval("650031-650033"));
            bins.addAll(buildBinInterval("650035-650051"));
            bins.addAll(buildBinInterval("650405-650439"));
            bins.addAll(buildBinInterval("650485-650538"));
            bins.addAll(buildBinInterval("650541-650598"));
            bins.addAll(buildBinInterval("650700-650718"));
            bins.addAll(buildBinInterval("650720-650727"));
            bins.addAll(buildBinInterval("650901-650920"));
            bins.addAll(buildBinInterval("651652-651679"));
            bins.addAll(buildBinInterval("655000-655019"));
            bins.addAll(buildBinInterval("655021-655058"));

            return bins.toArray(new String[bins.size()]);
        }

        private static String[] buildHiperCardBinList(){
            return new String[]{"384100","606282","637095"};
        }

        private static List<String> buildBinInterval(String interval){
            Integer firstBin = Integer.valueOf(interval.split("-")[0]);
            Integer lastBin = Integer.valueOf(interval.split("-")[1]);

            List<String> bins = new ArrayList<>(1);

            for(;firstBin <= lastBin; firstBin++ ){
                bins.add(firstBin.toString());
            }

            return  bins;
        }

        public static CreditCardInfo get(String cardBin) {
            return lookup.get(cardBin);
        }

        public String[] getCardBin() {
            return cardBin;
        }

        public void setCardBin(String[] cardBin) {
            this.cardBin = cardBin;
        }

        public CreditCardInfo getCreditCardInfo() {
            return creditCardInfo;
        }

        public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
            this.creditCardInfo = creditCardInfo;
        }
    }

