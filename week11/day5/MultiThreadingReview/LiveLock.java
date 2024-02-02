package day5.MultiThreadingReview;

public class LiveLock {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        PhoneCall buddy1 = new PhoneCall("Sam");
        PhoneCall buddy2= new PhoneCall("Sean");

        HangUpButton s = new HangUpButton(buddy1);

        new Thread(new Runnable() {
            public void run() {
                buddy1.callWith(s, buddy2);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                buddy2.callWith(s, buddy1);
            }
        }).start();

    }

    static class HangUpButton {
        private PhoneCall owner;

        public HangUpButton(PhoneCall o) {
            owner = o;
        }

        public PhoneCall getOwner() {
            return owner;
        }

        public synchronized void setOwner(PhoneCall o) {
            owner = o;
        }
        public synchronized void use() {
            System.out.printf("Has hung up!", owner.name);
        }
        
    }

    static class PhoneCall {
        private String name;
        private boolean isDone;

        public PhoneCall(String n) {
            name = n; isDone = true;
        }

        public String getName() {
            return name;
        }

        public boolean isDone() {
            return isDone;
        }

        public void callWith(HangUpButton hangUpButton, PhoneCall buddy) {
            while(isDone) {
                if(hangUpButton.owner != this) {
                    try {
                        Thread.sleep(100);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                        continue;
                    }
                    if(buddy.isDone()) {
                        System.out.printf("You hang up, buddy %s!%n", name, buddy.getName());
                        hangUpButton.setOwner(buddy);
                        continue;
                    }
                }
            }
        }
    }
}
