package com.sergosoft.spacecatsmarket.service;

import com.sergosoft.spacecatsmarket.domain.CustomerDetails;
import java.util.List;

public interface CustomerService {

    List<CustomerDetails> getAllCustomerDetails();

    CustomerDetails getCustomerDetailsById(Long customerId);
}
