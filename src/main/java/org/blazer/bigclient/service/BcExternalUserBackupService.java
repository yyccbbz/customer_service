package org.blazer.bigclient.service;

import org.blazer.bigclient.model.BcExcel;
import org.blazer.bigclient.model.BcExternalUserBackup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cuican on 2016-9-5.
 */
@Service
public class BcExternalUserBackupService extends BaseService<BcExternalUserBackup> {

    @Autowired
    private BcExcelService bcExcelService;

    public void importExcelData(List<BcExternalUserBackup> listBean, BcExcel bcExcel) {

        int i = bcExcelService.save(bcExcel);
        System.out.println("i = " + i);

        if (!listBean.isEmpty() && listBean.size() > 0) {

            for (int j = 0; j < listBean.size(); j++) {
                BcExternalUserBackup user = listBean.get(j);
                user.setExcelId(bcExcel.getId());
                user.setMtime(new Date());
                user.setCtime(user.getMtime());
                this.save(user);
            }

        }
    }

}
