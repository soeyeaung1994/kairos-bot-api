package com.bank.kairos.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: Soe Ye Aung
 * @Date: 13/6/25
 * @Time: 7:32 pm
 */
public interface MetadataService {
    List<Map<String, String>> getQuestionsByDocTypeId(Long docTypeId);
}
