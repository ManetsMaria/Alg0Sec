package test.parser;

import main.parser.Parser;
import main.parser.ParserFileRules;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ParserFileRulesTest {

    Parser parser;
    String[] lines = {"#Software: SGOS 5.4.3.7",
            "#Version: 1.0",
            "  \" \"",
            "  ",
            "#Start-Date: 2011-08-04 21:00:00",
            "#Da",
            "#Fields: date time time-taken c-ip cs-username   cs-auth-group x-exception-id    sc-filter-result cs-categories cs(Referer) sc-status s-action cs-method rs(Content-Type) cs-uri-scheme  cs-uri-port cs-uri-path cs-uri-query cs-uri-extension cs(User-Agent) s-ip sc-bytes  \"cs -bytes\" x-virus-id cs-host",
            "#Remark: 2610140037 \"SG-42\" \"82.137.200.42\" \"main\"",
            "2011-08-04 21:00:00 11 0.0.0.0 - - - OBSERVED \"unavailable\" -  200 TCP_HIT GET application/octet-stream http  80 /flatfile ?f1-020300031202230-d.50200.391 - \"GoogleEarth/6.0.3.2197(Windows;Microsoft Windows (5.1.2600.3);en-US;kml:2.2;client:Free;type:default)\" 82.137.200.42 16827 406 - kh.google.com",
            "2011-08-04 21:00:00 9311 0.0.0.0 - - - OBSERVED \"unavailable\" -  200 TCP_NC_MISS GET application/x-gzip http  80 /update/wks_avira10/win32/en/pecl/en-us/avwin.chm.gz - gz \"AntiVir-NGUpd/10.0.0.37 (PERS; WKS; EN; AVE 8.2.4.192; VDF 7.11.5.161; Windows 7; ; Syria; 273f27fe2dcb34b53c75441c4c0e56765a336283; 0000149996-ADJIE-0000001; SY; 10.0.0.648)\" 82.137.200.42 875853 384 - personal.avira-update.com",
            "2011-08-04 21:00:00 1705 0.0.0.0 - - - OBSERVED \"unavailable\" http://www.shukumaku.com/Content.php?id=30873  200 TCP_NC_MISS GET text/html  80 /quick.php - php \"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; InfoPath.1; AskTbPTV2/5.8.0.12304)\" 82.137.200.42 279 638 - http www.shukumaku.com",
            "2011-08-04 21:00:00 1705 0.0.0.0 - - - OBSERVED \"unavailable\" http://www.shukumaku.com/Content.php?id=30873  200 TCP_NC_MISS GET text/html  80 /quick.php - php \"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; InfoPath.1; AskTbPTV2/5.8.0.12304)\" 82.137.200.42 279 638 - -",
            "2011-08-04 21:00:00 1705 0.0.0.0 - - - OBSERVED \"unavailable\" http://www.shukumaku.com/Content.php?id=30873  200 TCP_NC_MISS GET text/html  80 /quick.php - php \"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; InfoPath.1; AskTbPTV2/5.8.0.12304)\" 82.137.200.42 279 638 -",
            "2011-08-04 21:00:00 19 0.0.0.0 - - - OBSERVED \"unavailable\" http://www.p33p.com/p33p-798.html  200 TCP_HIT GET application/x-shockwave-flash  80 /AFG_PRO_Plus_v10.swf ?pub=6265800474906769&swfURL=http://www.p33p.com/files/file/a6f2032f.swf swf \"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.2; BRI/2)\" 82.137.200.42 2006 809 - http www.p33p.com",
            "2011-08-04 21:00:00 168 0.0.0.0 - - - OBSERVED \"unavailable\" http://s7.addthis.com/static/r07/sh47.html  200 TCP_NC_MISS GET image/gif http  80 /live/t00/250lo.gif ?euys1x&uid=4de5b81aa16972b8&pub=addxvideos&rev=102809&si=4e293d0aea730a77&lc=MDAwMDBBU1NZMDAyMTM1MjE2MzAwMDAwMDAwVg%3D%3D&ln=ar&pc=men&cb=1&uf=0&ct=1&lt=49&pi=2&dp=www.xvideos.com&fp=new%2F44%2F%26usg%3DALkJrhgVhqh5vy2fCRlCsTetuyHQgUeCwg gif \"Mozilla/5.0 (Windows NT 5.1; rv:5.0) Gecko/20100101 Firefox/5.0\" 82.137.200.42 389 594 - l.addthiscdn.com",
            ""};

    @BeforeClass
    public void fileFormatParserTest(){
        parser = new ParserFileRules();
        ((ParserFileRules) parser).analyzeAllLines(Arrays.asList(lines));
    }

    @Test
    public void hostPlaceTest(){
        Assert.assertEquals(parser.getHostIndex(), 24);
    }

    @Test
    public void hostUniqueTest(){
        Set expected = new TreeSet();
        expected.add("www.shukumaku.com");
        expected.add("l.addthiscdn.com");
        expected.add("personal.avira-update.com");
        expected.add("kh.google.com");
        expected.add("www.p33p.com");
        Assert.assertEquals(parser.getAllUniqueHosts(), expected);
    }
}
