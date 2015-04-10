package com.example.iit.materialdesign.model;

import java.util.ArrayList;

/**
 * Created by IIT on 4/8/2015.
 */
public class Comment {
    private long id;
    private String starName;
    private String starFlux;
    public ArrayList<String> stars = new ArrayList<String>();;

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public String getStarFlux() {
        return starFlux;
    }

    public void setStarFlux(String starFlux) {
        this.starFlux = starFlux;
    }

    @Override
    public String toString() {
        return starName;
    }

    public ArrayList<String> getStars(){
        stars.add("Sco X-1");
        stars.add("GX 5-1");
        stars.add("Crab");
        stars.add("GX 17+2");
        stars.add("GX 349+2");
        stars.add("GX 9+1");
        stars.add("Cyg X-2");
        stars.add("GX 340+0");
        stars.add("GX 13+1");
        stars.add("Cyg X-1");
        stars.add("4U 1705-440");
        stars.add("NGC 6624");
        stars.add("GX 3+1");
        stars.add("GX 9+9");
        stars.add("1RXS J180408.9-342058");
        stars.add("Vela X-1");
        stars.add("Ser X-1");
        stars.add("GX 339-4");
        stars.add("1A 1742-294");
        stars.add("SAX J1747.0-2853");
        stars.add("GRS 1915+105");
        stars.add("Galactic Center Region");
        stars.add("H 1730-333_Rapid-Burster with Slow-Burster");
        stars.add("H 1735-444");
        stars.add("Cyg X-3");
        stars.add("GX 354-0_Slow-Burster with Rapid-Burster");
        stars.add("GS 1826-238, V4634 Sgr");
        stars.add("Terzan 5");
        stars.add("4U 1630-472");
        stars.add("NGC 6440");
        stars.add("SMC X-1");
        stars.add("Cen X-3");
        stars.add("4U 1624-490");
        stars.add("H 0614+091");
        stars.add("Perseus Cluster");
        stars.add("H 1636-536");
        stars.add("4U 1708-40");
        stars.add("X Per");
        stars.add("ESO 548-81");
        stars.add("Terzan 2");
        stars.add("2MASX J21383340+3205060");
        stars.add("Ophiuchus Cluster");
        stars.add("MCG -05-23-016");
        stars.add("HETE J1900.1-2455");
        stars.add("Cas A");
        stars.add("4U 1957+115");
        stars.add("IGR J19294+1816");
        stars.add("4U 1254-690");
        stars.add("MAXI J1305-704");
        stars.add("GK Per");
        stars.add("Cyg A");
        stars.add("Vela Pulsar and SNR");
        stars.add("1E 1547.0-5408");
        stars.add("Cir X-1");
        stars.add("Coma Cluster");
        stars.add("QSO B2356-309");
        stars.add("4U 1746-37");
        stars.add("4U 1538-52");
        stars.add("4U 1210-64");
        stars.add("MAXI J1735-304");
        stars.add("2MASX J16115141-6037549");
        stars.add("PSR B1509-58");
        stars.add("H 1822-000");
        stars.add("Cep X-4");
        stars.add("1E1145.1-6141");
        stars.add("Gamma Cas");
        stars.add("X 0922-314");
        stars.add("4U 1543-624");
        stars.add("4U 1822-371");
        stars.add("V709 Cas");
        stars.add("2MASX J09594263-3112581");
        stars.add("SZ Psc");
        stars.add("GS 0834-430");
        stars.add("4U 0513-40");
        stars.add("MAXI J0511-522");
        stars.add("4C +74.26");
        stars.add("M 87");
        stars.add("PG 1553+113");
        stars.add("XTE J1701-407");
        stars.add("Mrk 421");
        stars.add("H 1145-619");
        stars.add("NGC 7603");
        stars.add("V1223 Sgr");
        stars.add("XTE J1859+083");
        stars.add("SAX J1810.8-2609");
        stars.add("XTE J1752-223");
        stars.add("Terzan 1");
        stars.add("XTE J1709-267");
        stars.add("LMC X-2");
        stars.add("Abell 3558");
        stars.add("MAXI J1910-057");
        stars.add("1ES 0033+595");
        stars.add("SLX 1735-269");
        stars.add("1H 1556-605");
        stars.add("Mrk 509");
        stars.add("EXO 2030+375");
        stars.add("Abell 3266");
        stars.add("EX Hya");
        stars.add("4U 1954+319");
        stars.add("V4641 Sgr");
        stars.add("MRC 0625-536");
        stars.add("H 1553-542");
        stars.add("Eta Car");
        stars.add("Sct X-1");
        stars.add("Algol");
        stars.add("Abell 2256");
        stars.add("Abell 85");
        stars.add("Abell 3395");
        stars.add("1ES 0502+675");
        stars.add("MAXI J1421-613");
        stars.add("Fairall 9");
        stars.add("NGC 2110");
        stars.add("NGC 6814 with V1432 Aql");
        stars.add("TV Col");
        stars.add("GRO J1655-40");
        stars.add("Ark 120");
        stars.add("1H 0419-577");
        stars.add("NGC 5506");
        stars.add("OAO 1657-41");
        stars.add("FO Aqr");
        stars.add("Abell 3667");
        stars.add("SS 433");
        stars.add("Her X-1");
        stars.add("Mrk 1148");
        stars.add("Pup A");
        stars.add("NGC 3783");
        stars.add("NGC 5548");
        stars.add("Swift J1834.9-0846");
        stars.add("IGR J18410-0535");
        stars.add("Swift J0549");
        stars.add("3C 279");
        stars.add("Tycho SNR");
        stars.add("II Peg");
        stars.add("GRS 1747-312");
        stars.add("PSR B1259-63");
        stars.add("RX J1832-33");
        stars.add("XTE J1650-500");
        stars.add("VY Ari");
        stars.add("IGR J18483-0311");
        stars.add("SN 1006");
        stars.add("LMC X-1");
        stars.add("3C 390.3");
        stars.add("A 0535+262");
        stars.add("LMC X-4");
        stars.add("1E 1841-045");
        stars.add("MCG -02-08-038");
        stars.add("GS 1354-64");
        stars.add("MAXI J0057-720");
        stars.add("SGR 1833-0832");
        stars.add("NGC 973");
        stars.add("Abell 2199");
        stars.add("4U 0142+61");
        stars.add("4U 1344-60");
        stars.add("BY Cam");
        stars.add("NGC 5995");
        stars.add("UX Ari");
        stars.add("GRO J1008-57");
        stars.add("HR1099");
        stars.add("3C 120");
        stars.add("DO Dra");
        stars.add("4U 1323-619");
        stars.add("PKS 0521-365");
        stars.add("NGC 3516");
        stars.add("OJ 287");
        stars.add("M 31");
        stars.add("V 0332+53");
        stars.add("NGC 3227");
        stars.add("4U 1543-475");
        stars.add("3C 129");
        stars.add("1H 0918-548");
        stars.add("1ES 1101-23.2");
        stars.add("HD 347929");
        stars.add("3C 66A");
        stars.add("4U 1850-086");
        stars.add("MAXI J1409-619");
        stars.add("4U 1137-65");
        stars.add("BD +62 70");
        stars.add("EXO 0748-676");
        stars.add("Abell 401");
        stars.add("4U 1608-52");
        stars.add("IGR J13020-6359");
        stars.add("Swift J1357.2-0933");
        stars.add("ESO 141-55");
        stars.add("4U 1916-05");
        stars.add("RCW 86");
        stars.add("IM Peg");
        stars.add("Fairall 49");
        stars.add("2S 0921-63");
        stars.add("PSR J1023+0038");
        stars.add("MAXI J1836-194");
        stars.add("IC 4329A");
        stars.add("2MASX J11454045-1827149");
        stars.add("AO Psc");
        stars.add("IGR J16194-2810");
        stars.add("PKS 1510-08");
        stars.add("RX J0520.5-6932");
        stars.add("YZ CMi");
        stars.add("GRS 1739-278");
        stars.add("MAXI J1932+091");
        stars.add("PKS 2155-304");
        stars.add("Antares");
        stars.add("GS 1843+00");
        stars.add("GS 2000+251");
        stars.add("Spica");
        stars.add("Orion Nebula");
        stars.add("MCG -02-12-050");
        stars.add("1A 1246-588");
        stars.add("MAXI J1828-249");
        stars.add("TrA Cluster");
        stars.add("3C 111");
        stars.add("Abell 3571");
        stars.add("4U 1626-67");
        stars.add("Abell 1795");
        stars.add("1ES 1426+428");
        stars.add("MR 2251-178");
        stars.add("ESO 103-035");
        stars.add("RGB J1117+202");
        stars.add("NGC 2617");
        stars.add("LS I +61 303");
        stars.add("MWC 148");
        stars.add("Abell 2063");
        stars.add("XSS J12270-4859");
        stars.add("Abell 2163");
        stars.add("CIZA J1324.7-5736");
        stars.add("GX 301-2");
        stars.add("GX 304-1");
        stars.add("M 82");
        stars.add("MCG -06-30-15");
        stars.add("4U 0114+65");
        stars.add("2MASX J00341665-7905204");
        stars.add("Abell 754");
        stars.add("M 95");
        stars.add("Swift J1741.5-6548");
        stars.add("M 51");
        stars.add("Aql X-1");
        stars.add("4C +18.51");
        stars.add("Swift J1706.6-6146");
        stars.add("GS 2023+338");
        stars.add("NGC 7469");
        stars.add("NGC 7582");
        stars.add("S5 0716+71");
        stars.add("VW Hyi");
        stars.add("ClG 0745-1910");
        stars.add("3C 382");
        stars.add("1ES 0647+25.0");
        stars.add("NGC 1068");
        stars.add("MCG -01-13-025");
        stars.add("LAT J1512-3221");
        stars.add("GX 1+4");
        stars.add("XTE J1118+480");
        stars.add("SAX J2103.5+4545");
        stars.add("Abell 644");
        stars.add("1ES 0414+009");
        stars.add("IRAS 05078+1626");
        stars.add("NGC 6860");
        stars.add("AT Mic");
        stars.add("KS 1947+300");
        stars.add("Abell 262");
        stars.add("IGR J17191-2821");
        stars.add("MCG +08-11-011");
        stars.add("Swift J1753.5-0127");
        stars.add("NGC 1365");
        stars.add("3C 273");
        stars.add("4U 1705-32");
        stars.add("Zeta Ori");
        stars.add("2S 1417-624");
        stars.add("NGC 4151");
        stars.add("NGC 7172");
        stars.add("1ES 1959+650");
        stars.add("NGC 4051");
        stars.add("4U 0728-25");
        stars.add("XTE J1908+094");
        stars.add("MCG -01-24-012");
        stars.add("AP Lib");
        stars.add("4U 1711-34");
        stars.add("1ES 1011+496");
        stars.add("4U 1700+24");
        stars.add("SGR 0418+5729");
        stars.add("ZwCl 0335+0956");
        stars.add("GRO J2058+42");
        stars.add("XTE J1810-189");
        stars.add("NGC 4593");
        stars.add("Betelgeuse");
        stars.add("Cen X-4");
        stars.add("GRB130505B");
        stars.add("ON 231");
        stars.add("2FGL J1931.1+0938");
        stars.add("Cen A");
        stars.add("NGC 5252");
        stars.add("Abell 2029");
        stars.add("NGC 931");
        stars.add("SWIFT J1626.6-5156");
        stars.add("Swift J1822.3-1606");
        stars.add("Abell 496");
        stars.add("Abell 478");
        stars.add("V2674 Oph");
        stars.add("XTE J1858+034");
        stars.add("Mrk 110");
        stars.add("MXB 0656-072");

        return stars;
    }
}
