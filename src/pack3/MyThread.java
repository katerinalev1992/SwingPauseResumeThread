package pack3;

import javax.swing.*;

/**
 * Created by katerynalevytska on 3/21/17.
 */
class MyThread extends Thread {

    JTextArea area;
    private final Object GUI_INITIALIZATION_MONITOR = new Object();
    private boolean pauseThreadFlag = false;

    public MyThread(JTextArea area) {
        super();
        this.area = area;
    }

    @Override
    public void run() {
        for(int i=0 ; ; i++) {
            checkForPaused();
            area.setText(i+"");
        }
    }

    private void checkForPaused() {
        synchronized (GUI_INITIALIZATION_MONITOR) {
            while (pauseThreadFlag) {
                try {
                    GUI_INITIALIZATION_MONITOR.wait();
                } catch (Exception e) {}
            }
        }
    }

    public void pauseThread() throws InterruptedException {
        pauseThreadFlag = true;
    }

    public void resumeThread() {
        synchronized(GUI_INITIALIZATION_MONITOR) {
            pauseThreadFlag = false;
            GUI_INITIALIZATION_MONITOR.notify();
        }
    }
}

