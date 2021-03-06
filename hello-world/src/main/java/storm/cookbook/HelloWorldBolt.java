package storm.cookbook;

import org.apache.log4j.Logger;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.Map;

public class HelloWorldBolt extends BaseRichBolt {
    public static Logger LOG = Logger.getLogger(HelloWorldBolt.class);

    private static final long serialVersionUID = -841805977046116528L;
    private int myCount = 0;
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {

    }

    public void execute(Tuple tuple) {
        String test = tuple.getStringByField("sentence");
        if (test == "Hello World") {
            myCount++;
            System.out.println("Found a hello world, myCount is now: " + Integer.toString(myCount));
            LOG.debug("Found a Hello World! My Count is now: " + Integer.toString(myCount));
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
