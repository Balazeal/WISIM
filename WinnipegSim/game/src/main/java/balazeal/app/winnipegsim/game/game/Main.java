package balazeal.app.winnipegsim.game.game;

/**
 * Created by Joshua on 08/08/2014.
 */
public class Main {

    private String newline = "\n";
    private String log;

    public Main(){
        log = "Winnipeg Simulator 2014\n";
    }

    public String processText(String in){
        if(in != null && in.length() > 0){
            in = process(in);
            log = log.concat(in);
        }
        return log;
    }

    private String process(String in){
        //Do things with the input
        in = new String("> ").concat(in).concat(newline);
        return in;
    }

}
