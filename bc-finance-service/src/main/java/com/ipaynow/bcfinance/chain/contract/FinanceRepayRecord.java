package com.ipaynow.bcfinance.chain.contract;

import com.cryptape.cita.abi.EventEncoder;
import com.cryptape.cita.abi.EventValues;
import com.cryptape.cita.abi.FunctionEncoder;
import com.cryptape.cita.abi.TypeReference;
import com.cryptape.cita.abi.datatypes.Event;
import com.cryptape.cita.abi.datatypes.Type;
import com.cryptape.cita.abi.datatypes.Utf8String;
import com.cryptape.cita.abi.datatypes.generated.Uint128;
import com.cryptape.cita.abi.datatypes.generated.Uint256;
import com.cryptape.cita.abi.datatypes.generated.Uint8;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.DefaultBlockParameter;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.request.AppFilter;
import com.cryptape.cita.protocol.core.methods.response.Log;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.tuples.generated.Tuple8;
import com.cryptape.cita.tx.Contract;
import com.cryptape.cita.tx.TransactionManager;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/cryptape/citaj/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with citaj version 0.24.0.
 */
public class FinanceRepayRecord extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051602080610a208339810180604052602081101561003057600080fd5b810190808051906020019092919050505080600060106101000a8154816fffffffffffffffffffffffffffffffff02191690836fffffffffffffffffffffffffffffffff160217905550506109968061008a6000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80632e49d78b146100515780634a1460e6146100825780634e69d560146101e9578063eec992221461020d575b600080fd5b6100806004803603602081101561006757600080fd5b81019080803560ff1690602001909291905050506103c3565b005b61008a61041e565b60405180896fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff168152602001886fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff1681526020018781526020018681526020018581526020018460ff1660ff1681526020018060200180602001838103835285818151815260200191508051906020019080838360005b83811015610140578082015181840152602081019050610125565b50505050905090810190601f16801561016d5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156101a657808201518184015260208101905061018b565b50505050905090810190601f1680156101d35780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b6101f16105d0565b604051808260ff1660ff16815260200191505060405180910390f35b6103c1600480360361010081101561022457600080fd5b8101908080356fffffffffffffffffffffffffffffffff16906020019092919080356fffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190803560ff169060200190929190803590602001906401000000008111156102a457600080fd5b8201836020820111156102b657600080fd5b803590602001918460018302840111640100000000831117156102d857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561033b57600080fd5b82018360208201111561034d57600080fd5b8035906020019184600183028401116401000000008311171561036f57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506105e7565b005b80600660006101000a81548160ff021916908360ff1602179055507f56f7a12ae1a242b62ea95882be7d1afedff55d8481a724da808b12575bfc8cca81604051808260ff1660ff16815260200191505060405180910390a150565b6000806000806000806060806000809054906101000a90046fffffffffffffffffffffffffffffffff169750600060109054906101000a90046fffffffffffffffffffffffffffffffff1696506001549550600254945060038054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561050b5780601f106104e05761010080835404028352916020019161050b565b820191906000526020600020905b8154815290600101906020018083116104ee57829003601f168201915b5050505050915060048054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105a85780601f1061057d576101008083540402835291602001916105a8565b820191906000526020600020905b81548152906001019060200180831161058b57829003601f168201915b505050505090506005549350600660009054906101000a900460ff1692509091929394959697565b6000600660009054906101000a900460ff16905090565b866fffffffffffffffffffffffffffffffff16600060109054906101000a90046fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff161461069e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260178152602001807f5f72657061794964206e6f7420636f6e73697374656e7400000000000000000081525060200191505060405180910390fd5b876000806101000a8154816fffffffffffffffffffffffffffffffff02191690836fffffffffffffffffffffffffffffffff160217905550856001819055508460028190555081600390805190602001906106fa9291906108c5565b5080600490805190602001906107119291906108c5565b508360058190555082600660006101000a81548160ff021916908360ff1602179055507f43851b24ad82b0b0abb757af671f26a474026804274204d4e6c5f387d49d1470888888888888888860405180896fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff168152602001886fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff1681526020018781526020018681526020018581526020018460ff1660ff1681526020018060200180602001838103835285818151815260200191508051906020019080838360005b838110156108135780820151818401526020810190506107f8565b50505050905090810190601f1680156108405780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b8381101561087957808201518184015260208101905061085e565b50505050905090810190601f1680156108a65780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390a15050505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061090657805160ff1916838001178555610934565b82800160010185558215610934579182015b82811115610933578251825591602001919060010190610918565b5b5090506109419190610945565b5090565b61096791905b8082111561096357600081600090555060010161094b565b5090565b9056fea165627a7a7230582024e39f36ca53d30e33acf6b7f938058042f9c01f6033a25c63a5da8e3baae36e0029";

    protected FinanceRepayRecord(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        super(BINARY, contractAddress, citaj, transactionManager);
    }

    public List<DoBuildFinanceRepayRecordEventResponse> getDoBuildFinanceRepayRecordEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doBuildFinanceRepayRecord", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint128>() {}, new TypeReference<Uint128>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoBuildFinanceRepayRecordEventResponse> responses = new ArrayList<DoBuildFinanceRepayRecordEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoBuildFinanceRepayRecordEventResponse typedResponse = new DoBuildFinanceRepayRecordEventResponse();
            typedResponse._creditId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._repayId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._repayAmount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._repayPrinciple = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse._financeRateAmount = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse._status = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse._creditorId = (String) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse._debtorId = (String) eventValues.getNonIndexedValues().get(7).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoBuildFinanceRepayRecordEventResponse> doBuildFinanceRepayRecordEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doBuildFinanceRepayRecord", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint128>() {}, new TypeReference<Uint128>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoBuildFinanceRepayRecordEventResponse>() {
            @Override
            public DoBuildFinanceRepayRecordEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoBuildFinanceRepayRecordEventResponse typedResponse = new DoBuildFinanceRepayRecordEventResponse();
                typedResponse._creditId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._repayId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._repayAmount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._repayPrinciple = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse._financeRateAmount = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse._status = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse._creditorId = (String) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse._debtorId = (String) eventValues.getNonIndexedValues().get(7).getValue();
                return typedResponse;
            }
        });
    }

    public List<DoSetStatusEventResponse> getDoSetStatusEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doSetStatus", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoSetStatusEventResponse> responses = new ArrayList<DoSetStatusEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoSetStatusEventResponse typedResponse = new DoSetStatusEventResponse();
            typedResponse._status = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoSetStatusEventResponse> doSetStatusEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doSetStatus", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoSetStatusEventResponse>() {
            @Override
            public DoSetStatusEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoSetStatusEventResponse typedResponse = new DoSetStatusEventResponse();
                typedResponse._status = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> setStatus(BigInteger _status, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "setStatus", 
                Arrays.<Type>asList(new Uint8(_status)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>> getFinanceRepayRecord() {
        final com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("getFinanceRepayRecord", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint128>() {}, new TypeReference<Uint128>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>>(
                new Callable<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> getStatus() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("getStatus", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> buildFinanceRepayRecord(BigInteger _creditId, BigInteger _repayId, BigInteger _repayAmount, BigInteger _repayPrinciple, BigInteger _financeRateAmount, BigInteger _status, String _creditorId, String _debtorId, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "buildFinanceRepayRecord", 
                Arrays.<Type>asList(new Uint128(_creditId),
                new Uint128(_repayId),
                new Uint256(_repayAmount),
                new Uint256(_repayPrinciple),
                new Uint256(_financeRateAmount),
                new Uint8(_status),
                new Utf8String(_creditorId),
                new Utf8String(_debtorId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public static RemoteCall<FinanceRepayRecord> deploy(CITAj citaj, TransactionManager transactionManager, Long quota, String nonce, Long validUntilBlock, Integer version, String value, BigInteger chainId, BigInteger _repayId) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint128(_repayId)));
        return deployRemoteCall(FinanceRepayRecord.class, citaj, transactionManager, quota, nonce, validUntilBlock, version, chainId, value, BINARY, encodedConstructor);
    }

    public static FinanceRepayRecord load(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        return new FinanceRepayRecord(contractAddress, citaj, transactionManager);
    }

    public static class DoBuildFinanceRepayRecordEventResponse {
        public BigInteger _creditId;

        public BigInteger _repayId;

        public BigInteger _repayAmount;

        public BigInteger _repayPrinciple;

        public BigInteger _financeRateAmount;

        public BigInteger _status;

        public String _creditorId;

        public String _debtorId;
    }

    public static class DoSetStatusEventResponse {
        public BigInteger _status;
    }
}
