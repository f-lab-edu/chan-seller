package com.chan.seller.chanseller.client;

import com.chan.seller.chanseller.common.Message;
import com.chan.seller.chanseller.dto.InvoiceRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="logistics", url="${logistics.ribbon.listOfServers}")
public interface LogisticsClient {

    @PutMapping("/logistics/invoice")
    Message requestInvoice(@RequestBody InvoiceRequestDto invoiceRequestDto);
}
