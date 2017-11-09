public class CountingThread extends Thread
{
    private int pause;

    public void run()
    {
        for (int i = 0; i < 5; i++) {
            try {
            pause = (int)(Math.random()*3000);
            sleep(pause);
            System.out.println(i);
            }
            catch (InterruptedException iEx) {
                System.out.println(iEx);
            }
        }
    }

}
