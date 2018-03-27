package com.litte.ui.real;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.litte.ui.IPerson;

public class AIDLService extends Service {

    private String[] name = {"Jack","张","王","赵","李","钱","孙"};
    private IBinder binder = new PersonQueryBinder();

    public String query(int num) {
        if (num>0&&num<8){
            return name[num-1];
        }
        return null;
    }
    public AIDLService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public final class PersonQueryBinder extends IPerson.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String queryPerson(int num) throws RemoteException {
            return query(num);
        }
    }
}
