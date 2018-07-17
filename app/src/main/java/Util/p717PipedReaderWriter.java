package Util;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {
    private Random rand = new Random();
    public PipedWriter getPipedWriter() {
        return out;
    }
    private PipedWriter out = new PipedWriter();

    public void run() {
        try {
            while(true)
            {
                for (char c = 'A'; c < 'Z'; c++)
                {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch(IOException ex)
        {
            System.out.println("Sender Write exception");
        } catch(InterruptedException ex)
        {
            System.out.println("Sender Sleep interrupted");
        }
    }
}

class Receiver implements Runnable {
    private PipedReader in;
    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }
    public void run()
    {
        try {
            while(true)
            {
                System.out.println("Read: " + (char)in.read());
            }
        } catch (IOException ex)
        {
            System.out.println("Receiver Read exception");
        }
    }
}

public class p717PipedReaderWriter {

    public static void main(String[] args) throws Exception
    {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
