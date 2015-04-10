package com.example.iit.materialdesign;

import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.iit.materialdesign.model.Comment;

import java.util.ArrayList;

/**
 * Created by IIT on 4/8/2015.
 */
public abstract class BaseActivity extends ActionBarActivity {
    private static final int NUM_OF_ITEMS = 300;
    private static final int NUM_OF_ITEMS_FEW = 3;
//    static ArrayList<String> comments = new ArrayList<String>();
//    static Comment comment;

    protected int getActionBarSize() {
        TypedValue typedValue = new TypedValue();
        int[] textSizeAttr = new int[]{R.attr.actionBarSize};
        int indexOfAttrTextSize = 0;
        TypedArray a = obtainStyledAttributes(typedValue.data, textSizeAttr);
        int actionBarSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();
        return actionBarSize;
    }

    protected int getScreenHeight() {
        return findViewById(android.R.id.content).getHeight();
    }

    public static ArrayList<String> getDummyData() {
        return getDummyData(NUM_OF_ITEMS);
    }

    public static ArrayList<String> getDummyData(int num) {
        ArrayList<String> items = new ArrayList<String>();
        items.add("Sco X-1");
        items.add("GX 5-1");
        items.add("Crab");
        items.add("GX 17+2");
        items.add("GX 349+2");
        items.add("GX 9+1");
        items.add("Cyg X-2");
        items.add("GX 340+0");
        items.add("GX 13+1");
        items.add("Cyg X-1");
        items.add("4U 1705-440");
        items.add("NGC 6624");
        items.add("GX 3+1");
        items.add("GX 9+9");
        items.add("1RXS J180408.9-342058");
        items.add("Vela X-1");
        items.add("Ser X-1");
        items.add("GX 339-4");
        items.add("1A 1742-294");
        items.add("SAX J1747.0-2853");
        items.add("GRS 1915+105");
        items.add("Galactic Center Region");
        items.add("H 1730-333_Rapid-Burster with Slow-Burster");
        items.add("H 1735-444");
        items.add("Cyg X-3");
        items.add("GX 354-0_Slow-Burster with Rapid-Burster");
        items.add("GS 1826-238, V4634 Sgr");
        items.add("Terzan 5");
        items.add("4U 1630-472");
        items.add("NGC 6440");
        items.add("SMC X-1");
        items.add("Cen X-3");
        items.add("4U 1624-490");
        items.add("H 0614+091");
        items.add("Perseus Cluster");
        items.add("H 1636-536");
        items.add("4U 1708-40");
        items.add("X Per");
        items.add("ESO 548-81");
        items.add("Terzan 2");
        items.add("2MASX J21383340+3205060");
        items.add("Ophiuchus Cluster");
        items.add("MCG -05-23-016");
        items.add("HETE J1900.1-2455");
        items.add("Cas A");
        items.add("4U 1957+115");
        items.add("IGR J19294+1816");
        items.add("4U 1254-690");
        items.add("MAXI J1305-704");
        items.add("GK Per");
        items.add("Cyg A");
        items.add("Vela Pulsar and SNR");
        items.add("1E 1547.0-5408");
        items.add("Cir X-1");
        items.add("Coma Cluster");
        items.add("QSO B2356-309");
        items.add("4U 1746-37");
        items.add("4U 1538-52");
        items.add("4U 1210-64");
        items.add("MAXI J1735-304");
        items.add("2MASX J16115141-6037549");
        items.add("PSR B1509-58");
        items.add("H 1822-000");
        items.add("Cep X-4");
        items.add("1E1145.1-6141");
        items.add("Gamma Cas");
        items.add("X 0922-314");
        items.add("4U 1543-624");
        items.add("4U 1822-371");
        items.add("V709 Cas");
        items.add("2MASX J09594263-3112581");
        items.add("SZ Psc");
        items.add("GS 0834-430");
        items.add("4U 0513-40");
        items.add("MAXI J0511-522");
        items.add("4C +74.26");
        items.add("M 87");
        items.add("PG 1553+113");
        items.add("XTE J1701-407");
        items.add("Mrk 421");
        items.add("H 1145-619");
        items.add("NGC 7603");
        items.add("V1223 Sgr");
        items.add("XTE J1859+083");
        items.add("SAX J1810.8-2609");
        items.add("XTE J1752-223");
        items.add("Terzan 1");
        items.add("XTE J1709-267");
        items.add("LMC X-2");
        items.add("Abell 3558");
        items.add("MAXI J1910-057");
        items.add("1ES 0033+595");
        items.add("SLX 1735-269");
        items.add("1H 1556-605");
        items.add("Mrk 509");
        items.add("EXO 2030+375");
        items.add("Abell 3266");
        items.add("EX Hya");
        items.add("4U 1954+319");
        items.add("V4641 Sgr");
        items.add("MRC 0625-536");
        items.add("H 1553-542");
        items.add("Eta Car");
        items.add("Sct X-1");
        items.add("Algol");
        items.add("Abell 2256");
        items.add("Abell 85");
        items.add("Abell 3395");
        items.add("1ES 0502+675");
        items.add("MAXI J1421-613");
        items.add("Fairall 9");
        items.add("NGC 2110");
        items.add("NGC 6814 with V1432 Aql");
        items.add("TV Col");
        items.add("GRO J1655-40");
        items.add("Ark 120");
        items.add("1H 0419-577");
        items.add("NGC 5506");
        items.add("OAO 1657-41");
        items.add("FO Aqr");
        items.add("Abell 3667");
        items.add("SS 433");
        items.add("Her X-1");
        items.add("Mrk 1148");
        items.add("Pup A");
        items.add("NGC 3783");
        items.add("NGC 5548");
        items.add("Swift J1834.9-0846");
        items.add("IGR J18410-0535");
        items.add("Swift J0549");
        items.add("3C 279");
        items.add("Tycho SNR");
        items.add("II Peg");
        items.add("GRS 1747-312");
        items.add("PSR B1259-63");
        items.add("RX J1832-33");
        items.add("XTE J1650-500");
        items.add("VY Ari");
        items.add("IGR J18483-0311");
        items.add("SN 1006");
        items.add("LMC X-1");
        items.add("3C 390.3");
        items.add("A 0535+262");
        items.add("LMC X-4");
        items.add("1E 1841-045");
        items.add("MCG -02-08-038");
        items.add("GS 1354-64");
        items.add("MAXI J0057-720");
        items.add("SGR 1833-0832");
        items.add("NGC 973");
        items.add("Abell 2199");
        items.add("4U 0142+61");
        items.add("4U 1344-60");
        items.add("BY Cam");
        items.add("NGC 5995");
        items.add("UX Ari");
        items.add("GRO J1008-57");
        items.add("HR1099");
        items.add("3C 120");
        items.add("DO Dra");
        items.add("4U 1323-619");
        items.add("PKS 0521-365");
        items.add("NGC 3516");
        items.add("OJ 287");
        items.add("M 31");
        items.add("V 0332+53");
        items.add("NGC 3227");
        items.add("4U 1543-475");
        items.add("3C 129");
        items.add("1H 0918-548");
        items.add("1ES 1101-23.2");
        items.add("HD 347929");
        items.add("3C 66A");
        items.add("4U 1850-086");
        items.add("MAXI J1409-619");
        items.add("4U 1137-65");
        items.add("BD +62 70");
        items.add("EXO 0748-676");
        items.add("Abell 401");
        items.add("4U 1608-52");
        items.add("IGR J13020-6359");
        items.add("Swift J1357.2-0933");
        items.add("ESO 141-55");
        items.add("4U 1916-05");
        items.add("RCW 86");
        items.add("IM Peg");
        items.add("Fairall 49");
        items.add("2S 0921-63");
        items.add("PSR J1023+0038");
        items.add("MAXI J1836-194");
        items.add("IC 4329A");
        items.add("2MASX J11454045-1827149");
        items.add("AO Psc");
        items.add("IGR J16194-2810");
        items.add("PKS 1510-08");
        items.add("RX J0520.5-6932");
        items.add("YZ CMi");
        items.add("GRS 1739-278");
        items.add("MAXI J1932+091");
        items.add("PKS 2155-304");
        items.add("Antares");
        items.add("GS 1843+00");
        items.add("GS 2000+251");
        items.add("Spica");
        items.add("Orion Nebula");
        items.add("MCG -02-12-050");
        items.add("1A 1246-588");
        items.add("MAXI J1828-249");
        items.add("TrA Cluster");
        items.add("3C 111");
        items.add("Abell 3571");
        items.add("4U 1626-67");
        items.add("Abell 1795");
        items.add("1ES 1426+428");
        items.add("MR 2251-178");
        items.add("ESO 103-035");
        items.add("RGB J1117+202");
        items.add("NGC 2617");
        items.add("LS I +61 303");
        items.add("MWC 148");
        items.add("Abell 2063");
        items.add("XSS J12270-4859");
        items.add("Abell 2163");
        items.add("CIZA J1324.7-5736");
        items.add("GX 301-2");
        items.add("GX 304-1");
        items.add("M 82");
        items.add("MCG -06-30-15");
        items.add("4U 0114+65");
        items.add("2MASX J00341665-7905204");
        items.add("Abell 754");
        items.add("M 95");
        items.add("Swift J1741.5-6548");
        items.add("M 51");
        items.add("Aql X-1");
        items.add("4C +18.51");
        items.add("Swift J1706.6-6146");
        items.add("GS 2023+338");
        items.add("NGC 7469");
        items.add("NGC 7582");
        items.add("S5 0716+71");
        items.add("VW Hyi");
        items.add("ClG 0745-1910");
        items.add("3C 382");
        items.add("1ES 0647+25.0");
        items.add("NGC 1068");
        items.add("MCG -01-13-025");
        items.add("LAT J1512-3221");
        items.add("GX 1+4");
        items.add("XTE J1118+480");
        items.add("SAX J2103.5+4545");
        items.add("Abell 644");
        items.add("1ES 0414+009");
        items.add("IRAS 05078+1626");
        items.add("NGC 6860");
        items.add("AT Mic");
        items.add("KS 1947+300");
        items.add("Abell 262");
        items.add("IGR J17191-2821");
        items.add("MCG +08-11-011");
        items.add("Swift J1753.5-0127");
        items.add("NGC 1365");
        items.add("3C 273");
        items.add("4U 1705-32");
        items.add("Zeta Ori");
        items.add("2S 1417-624");
        items.add("NGC 4151");
        items.add("NGC 7172");
        items.add("1ES 1959+650");
        items.add("NGC 4051");
        items.add("4U 0728-25");
        items.add("XTE J1908+094");
        items.add("MCG -01-24-012");
        items.add("AP Lib");
        items.add("4U 1711-34");
        items.add("1ES 1011+496");
        items.add("4U 1700+24");
        items.add("SGR 0418+5729");
        items.add("ZwCl 0335+0956");
        items.add("GRO J2058+42");
        items.add("XTE J1810-189");
        items.add("NGC 4593");
        items.add("Betelgeuse");
        items.add("Cen X-4");
        items.add("GRB130505B");
        items.add("ON 231");
        items.add("2FGL J1931.1+0938");
        items.add("Cen A");
        items.add("NGC 5252");
        items.add("Abell 2029");
        items.add("NGC 931");
        items.add("SWIFT J1626.6-5156");
        items.add("Swift J1822.3-1606");
        items.add("Abell 496");
        items.add("Abell 478");
        items.add("V2674 Oph");
        items.add("XTE J1858+034");
        items.add("Mrk 110");
        items.add("MXB 0656-072");
        return items;
    }

    protected void setDummyData(ListView listView) {
        setDummyData(listView, NUM_OF_ITEMS);
    }

    protected void setDummyDataFew(ListView listView) {
        setDummyData(listView, NUM_OF_ITEMS_FEW);
    }

    protected void setDummyData(ListView listView, int num) {
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getDummyData(num)));
    }

    protected void setDummyDataWithHeader(ListView listView, int headerHeight) {
        setDummyDataWithHeader(listView, headerHeight, NUM_OF_ITEMS);
    }

    protected void setDummyDataWithHeader(ListView listView, int headerHeight, int num) {
        View headerView = new View(this);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, headerHeight));
        headerView.setMinimumHeight(headerHeight);
        // This is required to disable header's list selector effect
        headerView.setClickable(true);
        setDummyDataWithHeader(listView, headerView, num);
    }

    protected void setDummyDataWithHeader(ListView listView, View headerView, int num) {
        listView.addHeaderView(headerView);
        setDummyData(listView, num);
    }

    protected void setDummyData(GridView gridView) {
        gridView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getDummyData()));
    }

    protected void setDummyData(RecyclerView recyclerView) {
        setDummyData(recyclerView, NUM_OF_ITEMS);
    }

    protected void setDummyDataFew(RecyclerView recyclerView) {
        setDummyData(recyclerView, NUM_OF_ITEMS_FEW);
    }

    protected void setDummyData(RecyclerView recyclerView, int num) {
        recyclerView.setAdapter(new SimpleRecyclerAdapter(this, getDummyData(num)));
    }

    protected void setDummyDataWithHeader(RecyclerView recyclerView, int headerHeight) {
        View headerView = new View(this);
        headerView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, headerHeight));
        headerView.setMinimumHeight(headerHeight);
        // This is required to disable header's list selector effect
        headerView.setClickable(true);
        setDummyDataWithHeader(recyclerView, headerView);
    }

    protected void setDummyDataWithHeader(RecyclerView recyclerView, View headerView) {
        recyclerView.setAdapter(new SimpleHeaderRecyclerAdapter(this, getDummyData(), headerView));
    }
}
