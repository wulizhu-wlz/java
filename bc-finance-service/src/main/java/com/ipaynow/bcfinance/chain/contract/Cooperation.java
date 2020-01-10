package com.ipaynow.bcfinance.chain.contract;

import com.cryptape.cita.abi.EventEncoder;
import com.cryptape.cita.abi.EventValues;
import com.cryptape.cita.abi.FunctionEncoder;
import com.cryptape.cita.abi.TypeReference;
import com.cryptape.cita.abi.datatypes.Address;
import com.cryptape.cita.abi.datatypes.Bool;
import com.cryptape.cita.abi.datatypes.Event;
import com.cryptape.cita.abi.datatypes.Type;
import com.cryptape.cita.abi.datatypes.generated.Uint256;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.DefaultBlockParameter;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.request.AppFilter;
import com.cryptape.cita.protocol.core.methods.response.Log;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.tx.Contract;
import com.cryptape.cita.tx.TransactionManager;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://github.com/cryptape/citaj/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with citaj version 0.24.0.
 */
public class Cooperation extends Contract {
    private static final String BINARY = "6080604052600160025534801561001557600080fd5b50604051610cdb380380610cdb8339818101604052602081101561003857600080fd5b810190808051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146101005780600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5050610bca806101116000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c80638da5cb5b116100665780638da5cb5b14610178578063aa03fa3d146101c2578063ac0cc86814610230578063c246efe01461024e578063f2fde38b146102ca57610093565b8063458a766d1461009857806357dfb1cd146100fc578063715018a61461012a578063747293fb14610134575b600080fd5b6100fa600480360360408110156100ae57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061030e565b005b6101286004803603602081101561011257600080fd5b81019080803590602001909291905050506104ee565b005b610132610599565b005b6101766004803603602081101561014a57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610699565b005b610180610801565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101ee600480360360208110156101d857600080fd5b8101908080359060200190929190505050610826565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610238610862565b6040518082815260200191505060405180910390f35b6102b06004803603604081101561026457600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610868565b604051808215151515815260200191505060405180910390f35b61030c600480360360208110156102e057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610995565b005b60008290508073ffffffffffffffffffffffffffffffffffffffff16631d655c59336040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b15801561039057600080fd5b505afa1580156103a4573d6000803e3d6000fd5b505050506040513d60208110156103ba57600080fd5b81019080805190602001909291905050506103d457600080fd5b82600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507f2140eb00a64b73f64e981063b436821884e04c14acde7f8c051d6ebba6e6d9c38383604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a1505050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161461054857600080fd5b806002819055503373ffffffffffffffffffffffffffffffffffffffff16816002547f06d0981ddf88b524abcd78795702af5c17e6616ceb8eb4aa2b47db576d7a912060405160405180910390a450565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146105f257600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482060405160405180910390a260008060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b6106a16109fa565b806106f857506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b61070157600080fd5b60018190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f1f093a78a21a82ed6238de789572498070341906fef2e34101e9b99d3b10f0633382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a150565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6001818154811061083357fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b60008173ffffffffffffffffffffffffffffffffffffffff16600460008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061098d57508273ffffffffffffffffffffffffffffffffffffffff16600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b905092915050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146109ee57600080fd5b6109f781610a9d565b50565b6000806000905060008090505b600180549050811015610a95573373ffffffffffffffffffffffffffffffffffffffff1660018281548110610a3857fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610a885760019150610a95565b8080600101915050610a07565b508091505090565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415610ad757600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505056fea265627a7a72305820ff63f14ae9c25ad38a94e4b7e822f04a61b61c5d18358c63e51b99f82616934464736f6c63430005090032";

    protected Cooperation(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        super(BINARY, contractAddress, citaj, transactionManager);
    }

    public List<DoAddCooperationEventResponse> getDoAddCooperationEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doAddCooperation", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoAddCooperationEventResponse> responses = new ArrayList<DoAddCooperationEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoAddCooperationEventResponse typedResponse = new DoAddCooperationEventResponse();
            typedResponse.acc = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.accAnother = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoAddCooperationEventResponse> doAddCooperationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doAddCooperation", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoAddCooperationEventResponse>() {
            @Override
            public DoAddCooperationEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoAddCooperationEventResponse typedResponse = new DoAddCooperationEventResponse();
                typedResponse.acc = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.accAnother = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<DoChangeLifecycleEventResponse> getDoChangeLifecycleEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doChangeLifecycle", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoChangeLifecycleEventResponse> responses = new ArrayList<DoChangeLifecycleEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoChangeLifecycleEventResponse typedResponse = new DoChangeLifecycleEventResponse();
            typedResponse.oldLifecycle = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newLifecycle = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.contractAddr = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoChangeLifecycleEventResponse> doChangeLifecycleEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doChangeLifecycle", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoChangeLifecycleEventResponse>() {
            @Override
            public DoChangeLifecycleEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoChangeLifecycleEventResponse typedResponse = new DoChangeLifecycleEventResponse();
                typedResponse.oldLifecycle = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newLifecycle = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.contractAddr = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<AddCallerEventResponse> getAddCallerEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("AddCaller", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AddCallerEventResponse> responses = new ArrayList<AddCallerEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AddCallerEventResponse typedResponse = new AddCallerEventResponse();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.caller = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddCallerEventResponse> addCallerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("AddCaller", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, AddCallerEventResponse>() {
            @Override
            public AddCallerEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AddCallerEventResponse typedResponse = new AddCallerEventResponse();
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.caller = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<OwnershipRenouncedEventResponse> getOwnershipRenouncedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnershipRenounced", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OwnershipRenouncedEventResponse> responses = new ArrayList<OwnershipRenouncedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OwnershipRenouncedEventResponse typedResponse = new OwnershipRenouncedEventResponse();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipRenouncedEventResponse> ownershipRenouncedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnershipRenounced", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, OwnershipRenouncedEventResponse>() {
            @Override
            public OwnershipRenouncedEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OwnershipRenouncedEventResponse typedResponse = new OwnershipRenouncedEventResponse();
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> addCooperation(String ownerAccountAddr, String cooperatorAccountAddr, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "addCooperation", 
                Arrays.<Type>asList(new Address(ownerAccountAddr),
                new Address(cooperatorAccountAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> changeLifecycle(BigInteger _lifecycle, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "changeLifecycle", 
                Arrays.<Type>asList(new Uint256(_lifecycle)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> renounceOwnership(Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "renounceOwnership", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> addCaller(String _addressCall, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "addCaller", 
                Arrays.<Type>asList(new Address(_addressCall)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<String> owner() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> callers(BigInteger param0) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("callers", 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> lifecycle() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("lifecycle", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> isCooperation(String acc, String accAnother) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("isCooperation", 
                Arrays.<Type>asList(new Address(acc),
                new Address(accAnother)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "transferOwnership", 
                Arrays.<Type>asList(new Address(_newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public static RemoteCall<Cooperation> deploy(CITAj citaj, TransactionManager transactionManager, Long quota, String nonce, Long validUntilBlock, Integer version, String value, BigInteger chainId, String _superAdmin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_superAdmin)));
        return deployRemoteCall(Cooperation.class, citaj, transactionManager, quota, nonce, validUntilBlock, version, chainId, value, BINARY, encodedConstructor);
    }

    public static Cooperation load(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        return new Cooperation(contractAddress, citaj, transactionManager);
    }

    public static class DoAddCooperationEventResponse {
        public String acc;

        public String accAnother;
    }

    public static class DoChangeLifecycleEventResponse {
        public BigInteger oldLifecycle;

        public BigInteger newLifecycle;

        public String contractAddr;
    }

    public static class AddCallerEventResponse {
        public String sender;

        public String caller;
    }

    public static class OwnershipRenouncedEventResponse {
        public String previousOwner;
    }

    public static class OwnershipTransferredEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
