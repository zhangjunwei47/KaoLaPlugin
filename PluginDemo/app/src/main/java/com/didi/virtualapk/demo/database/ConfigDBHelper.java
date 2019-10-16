package com.didi.virtualapk.demo.database;

import android.content.Context;

import com.didi.virtualapk.demo.database.greendao.DaoMaster;
import com.didi.virtualapk.demo.database.greendao.DaoSession;
import com.kaolafm.base.util.ListUtils;

import org.greenrobot.greendao.database.Database;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author zhangchao on 2019/2/18.
 */

public class ConfigDBHelper {
    public static final int TYPE_PLAY_PARAMETER = 1;
    public static final int TYPE_REPORT_PRIVATE_PARAMETER = 2;
    public static final int TYPE_REPORT_CAR_PARAMETER = 3;


    private static final String DATA_BASE_NAME = "DBConfig.db";
    private static ConfigDBHelper configDBHelper;
    private DaoSession daoSession;
    private Context mContext;
    private ConfigDBHelper(Context context) {
        mContext = context;
    }


    public static ConfigDBHelper getInstance(Context context) {
        if (configDBHelper == null) {
            synchronized (ConfigDBHelper.class) {
                if (configDBHelper == null) {
                    configDBHelper = new ConfigDBHelper(context);
                }
            }
        }
        return configDBHelper;
    }

    public void init() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(mContext, DATA_BASE_NAME);
        Database database = devOpenHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }


    public Single<Long> insertData(ConfigData configData) {
        return Single.fromCallable(() -> {
            daoSession.insertOrReplace(configData);
            return daoSession.getConfigDataDao().count();
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Single<Long> deleteData(Long id) {
        return Single.fromCallable(() -> {
            daoSession.getConfigDataDao().deleteByKey(id);
            return daoSession.getConfigDataDao().count();
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
    }

    public Single<ConfigData> read(String type) {
        return Single.fromCallable(() -> {
            List<ConfigData> configDataList = daoSession.queryRaw(ConfigData.class, " where type = ?", type);
            if (ListUtils.isEmpty(configDataList)) {
                return null;
            }
            return configDataList.get(0);
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
    }


    public Single<List<ConfigData>> readAll() {
        return Single.fromCallable(() -> daoSession.loadAll(ConfigData.class)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
    }
}
