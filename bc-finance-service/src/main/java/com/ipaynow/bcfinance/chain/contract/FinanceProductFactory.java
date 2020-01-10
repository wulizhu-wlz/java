package com.ipaynow.bcfinance.chain.contract;

import com.cryptape.cita.abi.EventEncoder;
import com.cryptape.cita.abi.EventValues;
import com.cryptape.cita.abi.FunctionEncoder;
import com.cryptape.cita.abi.TypeReference;
import com.cryptape.cita.abi.datatypes.Address;
import com.cryptape.cita.abi.datatypes.Event;
import com.cryptape.cita.abi.datatypes.Type;
import com.cryptape.cita.abi.datatypes.Utf8String;
import com.cryptape.cita.abi.datatypes.generated.Uint256;
import com.cryptape.cita.abi.datatypes.generated.Uint8;
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
public class FinanceProductFactory extends Contract {
    private static final String BINARY = "6080604052600160025534801561001557600080fd5b5060405161177a38038061177a8339818101604052602081101561003857600080fd5b810190808051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146101005780600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5050611669806101116000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c8063ac0cc86811610066578063ac0cc868146101d7578063d800e37d146101f5578063e0976ae8146102fd578063ed5948871461036e578063f2fde38b146103df5761009e565b806357dfb1cd146100a3578063715018a6146100d1578063747293fb146100db5780638da5cb5b1461011f578063aa03fa3d14610169575b600080fd5b6100cf600480360360208110156100b957600080fd5b8101908080359060200190929190505050610423565b005b6100d96104ce565b005b61011d600480360360208110156100f157600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506105ce565b005b610127610736565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101956004803603602081101561017f57600080fd5b810190808035906020019092919050505061075b565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101df610797565b6040518082815260200191505060405180910390f35b6102bb6004803603604081101561020b57600080fd5b81019080803560ff1690602001909291908035906020019064010000000081111561023557600080fd5b82018360208201111561024757600080fd5b8035906020019184600183028401116401000000008311171561026957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929050505061079d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61032c6004803603602081101561031357600080fd5b81019080803560ff169060200190929190505050610a8d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61039d6004803603602081101561038457600080fd5b81019080803560ff169060200190929190505050610b42565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610421600480360360208110156103f557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610d06565b005b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161461047d57600080fd5b806002819055503373ffffffffffffffffffffffffffffffffffffffff16816002547f06d0981ddf88b524abcd78795702af5c17e6616ceb8eb4aa2b47db576d7a912060405160405180910390a450565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461052757600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482060405160405180910390a260008060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b6105d6610d6b565b8061062d57506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b61063657600080fd5b60018190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f1f093a78a21a82ed6238de789572498070341906fef2e34101e9b99d3b10f0633382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a150565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6001818154811061076857fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146107f857600080fd5b600073ffffffffffffffffffffffffffffffffffffffff16600460008560ff1660ff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161461086a57600080fd5b6000838360405161087a90610f06565b808360ff1660ff16815260200180602001828103825283818151815260200191508051906020019080838360005b838110156108c35780820151818401526020810190506108a8565b50505050905090810190601f1680156108f05780820380516001836020036101000a031916815260200191505b509350505050604051809103906000f080158015610912573d6000803e3d6000fd5b5090508073ffffffffffffffffffffffffffffffffffffffff16636b050c2260016040518263ffffffff1660e01b8152600401808260ff168152602001915050600060405180830381600087803b15801561096c57600080fd5b505af1158015610980573d6000803e3d6000fd5b5050505080600460008660ff1660ff16815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507f31b8207a130a8fb6175f4d5cb87cf91e369d366b4ec8395c30f20e74d60b67818484604051808360ff1660ff16815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610a4b578082015181840152602081019050610a30565b50505050905090810190601f168015610a785780820380516001836020036101000a031916815260200191505b50935050505060405180910390a15092915050565b60008073ffffffffffffffffffffffffffffffffffffffff16600460008460ff1660ff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610b0157600080fd5b600460008360ff1660ff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610b9d57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff16600460008460ff1660ff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610c1057600080fd5b6000600460008460ff1660ff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905060008190508073ffffffffffffffffffffffffffffffffffffffff16636b050c2260006040518263ffffffff1660e01b8152600401808260ff168152602001915050600060405180830381600087803b158015610caa57600080fd5b505af1158015610cbe573d6000803e3d6000fd5b505050507ffffd80f6119f2c272b590c35a48f707188d77d5295622da122c0aa7e0bc3f9da84604051808260ff1660ff16815260200191505060405180910390a15050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610d5f57600080fd5b610d6881610e0e565b50565b6000806000905060008090505b600180549050811015610e06573373ffffffffffffffffffffffffffffffffffffffff1660018281548110610da957fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610df95760019150610e06565b8080600101915050610d78565b508091505090565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415610e4857600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b61072180610f148339019056fe608060405234801561001057600080fd5b506040516107213803806107218339818101604052604081101561003357600080fd5b8101908080519060200190929190805164010000000081111561005557600080fd5b8281019050602081018481111561006b57600080fd5b815185600182028301116401000000008211171561008857600080fd5b5050929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508160ff1660018190555080600290805190602001906100f09291906101a2565b507f1733f2da274d51c72f192286e0d70bc627dd4e9c1b5e5c87bb2e9f486f5091e08282604051808360ff1660ff16815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610160578082015181840152602081019050610145565b50505050905090810190601f16801561018d5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a15050610247565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101e357805160ff1916838001178555610211565b82800160010185558215610211579182015b828111156102105782518255916020019190600101906101f5565b5b50905061021e9190610222565b5090565b61024491905b80821115610240576000816000905550600101610228565b5090565b90565b6104cb806102566000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c8063093857b21461005c5780636b050c2214610080578063715018a6146100b15780638da5cb5b146100bb578063f2fde38b14610105575b600080fd5b610064610149565b604051808260ff1660ff16815260200191505060405180910390f35b6100af6004803603602081101561009657600080fd5b81019080803560ff169060200190929190505050610160565b005b6100b9610214565b005b6100c3610314565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101476004803603602081101561011b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610339565b005b6000600360009054906101000a900460ff16905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146101b957600080fd5b80600360006101000a81548160ff021916908360ff1602179055507f77f096afdff2f19811aa4d9a89dcff7fa94d45955f89d02164d742f4765741dc81604051808260ff1660ff16815260200191505060405180910390a150565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461026d57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482060405160405180910390a260008060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461039257600080fd5b61039b8161039e565b50565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156103d857600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505056fea265627a7a723058205f8b0ec2361fcb5470019aea15edb930550f22a401259f0ad9837e8e9fa42d5264736f6c63430005090032a265627a7a72305820fcf363b1f7b60ece2211e765aa107f4b6456e97170a9f0c9ee0c0914365f205664736f6c63430005090032";

    protected FinanceProductFactory(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        super(BINARY, contractAddress, citaj, transactionManager);
    }

    public List<DoIssuesFinanceProductEventResponse> getDoIssuesFinanceProductEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doIssuesFinanceProduct", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoIssuesFinanceProductEventResponse> responses = new ArrayList<DoIssuesFinanceProductEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoIssuesFinanceProductEventResponse typedResponse = new DoIssuesFinanceProductEventResponse();
            typedResponse._productId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._productName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoIssuesFinanceProductEventResponse> doIssuesFinanceProductEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doIssuesFinanceProduct", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoIssuesFinanceProductEventResponse>() {
            @Override
            public DoIssuesFinanceProductEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoIssuesFinanceProductEventResponse typedResponse = new DoIssuesFinanceProductEventResponse();
                typedResponse._productId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._productName = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<DoFreezeFinanceProductEventResponse> getDoFreezeFinanceProductEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doFreezeFinanceProduct", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoFreezeFinanceProductEventResponse> responses = new ArrayList<DoFreezeFinanceProductEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoFreezeFinanceProductEventResponse typedResponse = new DoFreezeFinanceProductEventResponse();
            typedResponse._productId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoFreezeFinanceProductEventResponse> doFreezeFinanceProductEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doFreezeFinanceProduct", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoFreezeFinanceProductEventResponse>() {
            @Override
            public DoFreezeFinanceProductEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoFreezeFinanceProductEventResponse typedResponse = new DoFreezeFinanceProductEventResponse();
                typedResponse._productId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
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

    public RemoteCall<TransactionReceipt> issuesFinanceProduct(BigInteger _productId, String _productName, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "issuesFinanceProduct", 
                Arrays.<Type>asList(new Uint8(_productId),
                new Utf8String(_productName)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<String> getFinanceProduct(BigInteger _productId) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("getFinanceProduct", 
                Arrays.<Type>asList(new Uint8(_productId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> freezeFinanceProduct(BigInteger _productId, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "freezeFinanceProduct", 
                Arrays.<Type>asList(new Uint8(_productId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "transferOwnership", 
                Arrays.<Type>asList(new Address(_newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public static RemoteCall<FinanceProductFactory> deploy(CITAj citaj, TransactionManager transactionManager, Long quota, String nonce, Long validUntilBlock, Integer version, String value, BigInteger chainId, String _superAdmin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_superAdmin)));
        return deployRemoteCall(FinanceProductFactory.class, citaj, transactionManager, quota, nonce, validUntilBlock, version, chainId, value, BINARY, encodedConstructor);
    }

    public static FinanceProductFactory load(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        return new FinanceProductFactory(contractAddress, citaj, transactionManager);
    }

    public static class DoIssuesFinanceProductEventResponse {
        public BigInteger _productId;

        public String _productName;
    }

    public static class DoFreezeFinanceProductEventResponse {
        public BigInteger _productId;
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
