public class HelloCount
{

    public static void main(String[] args)
    {
        CountingThread ct = new CountingThread();
        HelloThread ht = new HelloThread();

        ct.start();
        ht.start();
    }

}
