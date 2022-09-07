package com.ben.restws;

import com.ben.restws.model.ChecksList;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.container.AsyncResponse;

@Service
public class CheckProcessorImpl implements CheckProcessor{
    @Override
    public void processChecks(AsyncResponse response, ChecksList checksList) {
        new Thread(){
            public void run() {
                if(checksList == null || checksList.getChecks().size() == 0 || checksList.getChecks() == null){
                    response.resume(new BadRequestException());
                }
                response.resume(true);
            }
        }.start();
    }
}
