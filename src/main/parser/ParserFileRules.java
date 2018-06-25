package main.parser;

import main.constant.StringConstant;

import java.util.List;

//make text file specific input
public class ParserFileRules extends Parser {

    @Override
    public void analyzeNextLine(String line) {
        if (line == null){
            return;
        }
        line = line.trim();
        if (line.isEmpty()){
            return;
        }
        int fieldsStartMarkerSize = StringConstant.FIELDS_START.length();
        if (line.charAt(0) == StringConstant.SERVICE_MARK) {
            if (line.length() > fieldsStartMarkerSize && line.substring(0, fieldsStartMarkerSize).equals(StringConstant.FIELDS_START)) {
                setHostOrder(line.substring(fieldsStartMarkerSize));
            }
            return;
        }
        addHostFromLine(line);
    }

    // we don't need any parsing for test file that's why can work with all lines
    public void analyzeAllLines(List<String> list) {
        if (list == null) {
            return;
        }
        for (String l : list) {
            analyzeNextLine(l);
        }
    }
}
