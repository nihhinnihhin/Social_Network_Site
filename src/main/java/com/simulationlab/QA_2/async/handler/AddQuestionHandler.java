package com.simulationlab.QA_2.async.handler;

import com.simulationlab.QA_2.async.EventHandler;
import com.simulationlab.QA_2.async.EventModel;
import com.simulationlab.QA_2.async.EventType;
import com.simulationlab.QA_2.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AddQuestionHandler implements EventHandler {

    private static final Logger logger = LoggerFactory.getLogger(AddQuestionHandler.class);

    @Autowired
    SearchService searchService;

    @Override
    public void doHandle(EventModel eventModel) {
        try {
            searchService.indexQuestion(eventModel.getEntityId(),
                    eventModel.getExt("title"), eventModel.getExt("content"));
        } catch (Exception e) {
            logger.error("添加问题索引失败" + e.getMessage());
        }
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.ADD_QUESTION);
    }

}
