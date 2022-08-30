package com.omoniyi24.client;

import com.omoniyi.service.BankService;
import com.omoniyi24.models.Balance;
import com.omoniyi24.models.BalanceCheckRequest;
import com.omoniyi24.models.BankServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.ManagedChannelImplBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @author OMONIYI ILESANMI
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankClientTest {

    private BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub;

    @BeforeAll
    public void setup(){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565)
            .usePlaintext()
            .build();

        this.bankServiceBlockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
    }

    @Test
    public void balanceTest(){
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
            .setAccountNumber(2)
            .build();
        Balance balance = this.bankServiceBlockingStub.getBalance(balanceCheckRequest);

        System.out.println("Received: " + balance.getAmount());
    }
}
