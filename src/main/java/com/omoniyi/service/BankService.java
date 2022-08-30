package com.omoniyi.service;

import com.omoniyi24.models.Balance;
import com.omoniyi24.models.BalanceCheckRequest;
import com.omoniyi24.models.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author OMONIYI ILESANMI
 */
public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> responseObserver) {

        int accountNumber = request.getAccountNumber();
        Balance balance = Balance.newBuilder()
            .setAmount(accountNumber * 10)
            .build();
        responseObserver.onNext(balance);
        responseObserver.onCompleted();
    }
}
