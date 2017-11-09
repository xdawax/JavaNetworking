public class ThreadOutput extends Thread
{
    public static void main(String[] argv)
    {
        ThreadOutput thread1 = new ThreadOutput();
        ThreadOutput thread2 = new ThreadOutput();

        thread1.start();
        thread2.start();

        
    }

    public void run()
    {
        int pause;

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(getName() + " is being executed");
                pause = (int)(Math.random()*3000);
                sleep(pause);
            }
            catch (InterruptedException iEx) {
                System.out.println(iEx);
            }
             
        }

        System.out.println(this.getName() + " has completed execution");

    }
    
}
