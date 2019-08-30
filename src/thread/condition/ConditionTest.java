package thread.condition;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest implements Callable<Integer> {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean FLAG = false;
    private ConditionTest(){

    }
    public static void main(String[] args){
        Callable c = new ConditionTest();
        FutureTask<Integer> ft = new FutureTask<Integer>(c);
        new Thread(ft).start();
        lock.lock();
        try{
            while(!FLAG){
                System.out.println("await ...");
                condition.await();
            }
            System.out.println(ft.get());
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    @Override
    public Integer call() throws Exception {
        lock.lock();
        try{
            FLAG = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("call...");
            condition.signal();
            lock.unlock();
            return 5;
        }
    }
}