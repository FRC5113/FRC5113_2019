package frc.subsystems;

import java.util.concurrent.locks.ReentrantLock;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDoutputImp implements PIDOutput{

    private double power;
    private ReentrantLock m_mutex = new ReentrantLock();

    public void reset() {
        m_mutex.lock();
        try 
        { power = 0; }
        finally
        { m_mutex.unlock(); }
    }

    public double get() {
        double ret = 0;

        m_mutex.lock();
        try
        {ret = power;}
        finally
        {m_mutex.unlock();}

        return ret;
    }

    @Override
    public void pidWrite(double output) {
        m_mutex.lock();
        try
        {power = output;}
        finally
        {m_mutex.unlock();}
    }
    
}