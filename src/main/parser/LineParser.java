package main.parser;

import main.constant.StringConstant;

import java.util.Arrays;
import java.util.List;

//universal for any log input type
public class LineParser {

    private List<String> split;

    public LineParser(String line){
        if (line != null){
            line = line.trim();
            if (!line.isEmpty()) {
                String[] fields = line.split(StringConstant.REGEX);
                split = Arrays.asList(fields);
                deleteDoubleQuotes();
            }
        }
    }

    // use for looking for hosts
    public String findWord(int place){
        if (split == null || split.size() <= place || place < 0){
            return null;
        }
        return split.get(place);
    }

    //use for looking for host place
    public int findPlace(String word){
        if (split == null || word == null){
            return -1;
        }
        return split.indexOf(word);
    }

    // not sure if we really need delete them but add for any cases (do not change asymptote time work)
    private void deleteDoubleQuotes(){
        if (split == null){
            return;
        }
        for (int i = 0; i < split.size(); i++){
            String l = split.get(i);
            if (l != null && !l.isEmpty()){
                if (l.charAt(0) == '"'){
                    split.set(i, l.substring(1, l.length() - 1));
                }
            }
        }
    }
}
