package com.ipaynow.bcfinance.chain.contract;

import com.cryptape.cita.abi.EventEncoder;
import com.cryptape.cita.abi.EventValues;
import com.cryptape.cita.abi.FunctionEncoder;
import com.cryptape.cita.abi.TypeReference;
import com.cryptape.cita.abi.datatypes.*;
import com.cryptape.cita.abi.datatypes.generated.Int32;
import com.cryptape.cita.abi.datatypes.generated.Uint256;
import com.cryptape.cita.abi.datatypes.generated.Uint32;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.DefaultBlockParameter;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.request.AppFilter;
import com.cryptape.cita.protocol.core.methods.response.Log;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.tuples.generated.Tuple9;
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
public class AssetStatement extends Contract {
    private static final String BINARY = "608060405260016002553480156200001657600080fd5b5060405162001aac38038062001aac83398101806040526101408110156200003d57600080fd5b81019080805190602001909291908051906020019092919080516401000000008111156200006a57600080fd5b828101905060208101848111156200008157600080fd5b81518560018202830111640100000000821117156200009f57600080fd5b50509291906020018051906020019092919080519060200190929190805190602001909291908051640100000000811115620000da57600080fd5b82810190506020810184811115620000f157600080fd5b81518560018202830111640100000000821117156200010f57600080fd5b505092919060200180516401000000008111156200012c57600080fd5b828101905060208101848111156200014357600080fd5b81518560018202830111640100000000821117156200016157600080fd5b505092919060200180516401000000008111156200017e57600080fd5b828101905060208101848111156200019557600080fd5b8151856001820283011164010000000082111715620001b357600080fd5b50509291906020018051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614620002805780600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50326000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555033600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060013390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505089600460146101000a81548163ffffffff021916908363ffffffff16021790555088600460186101000a81548163ffffffff021916908360030b63ffffffff1602179055508760059080519060200190620003c5929190620005c1565b5086600660006101000a81548163ffffffff021916908360030b63ffffffff16021790555085600660046101000a81548163ffffffff021916908360030b63ffffffff16021790555084600660086101000a81548163ffffffff021916908360030b63ffffffff16021790555083600790805190602001906200044a929190620005c1565b50826008908051906020019062000463929190620005c1565b5081600990805190602001906200047c929190620005c1565b507f07b46976200edd250711b207a94682a7bc583a350114307786a848ac0130a243600460149054906101000a900463ffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684604051808563ffffffff1663ffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200194505050505060405180910390a15050505050505050505062000670565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200060457805160ff191683800117855562000635565b8280016001018555821562000635579182015b828111156200063457825182559160200191906001019062000617565b5b50905062000644919062000648565b5090565b6200066d91905b80821115620006695760008160009055506001016200064f565b5090565b90565b61142c80620006806000396000f3fe608060405234801561001057600080fd5b50600436106101215760003560e01c8063747293fb116100ad578063ac0cc86811610071578063ac0cc86814610762578063af640d0f14610780578063ba0b1841146107aa578063ed6aaa0e146107ce578063f2fde38b146107f257610121565b8063747293fb146105605780637b1a3314146105a45780637c2ffbb3146106275780638da5cb5b146106aa578063aa03fa3d146106f457610121565b80635a540f2c116100f45780635a540f2c1461027d5780635e3109e7146102a15780635f86e2b0146104af5780636418dca814610532578063715018a61461055657610121565b806302d05d3f146101265780630730ca19146101705780631d655c59146101f357806357dfb1cd1461024f575b600080fd5b61012e610836565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61017861085c565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101b857808201518184015260208101905061019d565b50505050905090810190601f1680156101e55780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6102356004803603602081101561020957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506108fa565b604051808215151515815260200191505060405180910390f35b61027b6004803603602081101561026557600080fd5b8101908080359060200190929190505050610953565b005b6102856109fe565b604051808260030b60030b815260200191505060405180910390f35b6102a9610a11565b604051808a63ffffffff1663ffffffff1681526020018960030b60030b8152602001806020018860030b60030b81526020018760030b60030b81526020018660030b60030b815260200180602001806020018060200185810385528c818151815260200191508051906020019080838360005b8381101561033757808201518184015260208101905061031c565b50505050905090810190601f1680156103645780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b8381101561039d578082015181840152602081019050610382565b50505050905090810190601f1680156103ca5780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b838110156104035780820151818401526020810190506103e8565b50505050905090810190601f1680156104305780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b8381101561046957808201518184015260208101905061044e565b50505050905090810190601f1680156104965780820380516001836020036101000a031916815260200191505b509d505050505050505050505050505060405180910390f35b6104b7610d08565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156104f75780820151818401526020810190506104dc565b50505050905090810190601f1680156105245780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61053a610da6565b604051808260030b60030b815260200191505060405180910390f35b61055e610db9565b005b6105a26004803603602081101561057657600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610eb9565b005b6105ac611021565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156105ec5780820151818401526020810190506105d1565b50505050905090810190601f1680156106195780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61062f6110bf565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561066f578082015181840152602081019050610654565b50505050905090810190601f16801561069c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6106b261115d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6107206004803603602081101561070a57600080fd5b8101908080359060200190929190505050611182565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61076a6111be565b6040518082815260200191505060405180910390f35b6107886111c4565b604051808263ffffffff1663ffffffff16815260200191505060405180910390f35b6107b26111da565b604051808260030b60030b815260200191505060405180910390f35b6107d66111ed565b604051808260030b60030b815260200191505060405180910390f35b6108346004803603602081101561080857600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611200565b005b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60098054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108f25780601f106108c7576101008083540402835291602001916108f2565b820191906000526020600020905b8154815290600101906020018083116108d557829003601f168201915b505050505081565b60008173ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16149050919050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16146109ad57600080fd5b806002819055503373ffffffffffffffffffffffffffffffffffffffff16816002547f06d0981ddf88b524abcd78795702af5c17e6616ceb8eb4aa2b47db576d7a912060405160405180910390a450565b600660009054906101000a900460030b81565b600080606060008060006060806060600460149054906101000a900463ffffffff16600460189054906101000a900460030b6005600660009054906101000a900460030b600660049054906101000a900460030b600660089054906101000a900460030b600760086009868054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b105780601f10610ae557610100808354040283529160200191610b10565b820191906000526020600020905b815481529060010190602001808311610af357829003601f168201915b50505050509650828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bac5780601f10610b8157610100808354040283529160200191610bac565b820191906000526020600020905b815481529060010190602001808311610b8f57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c485780601f10610c1d57610100808354040283529160200191610c48565b820191906000526020600020905b815481529060010190602001808311610c2b57829003601f168201915b50505050509150808054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ce45780601f10610cb957610100808354040283529160200191610ce4565b820191906000526020600020905b815481529060010190602001808311610cc757829003601f168201915b50505050509050985098509850985098509850985098509850909192939495969798565b60058054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d9e5780601f10610d7357610100808354040283529160200191610d9e565b820191906000526020600020905b815481529060010190602001808311610d8157829003601f168201915b505050505081565b600460189054906101000a900460030b81565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610e1257600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482060405160405180910390a260008060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b610ec1611265565b80610f1857506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b610f2157600080fd5b60018190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f1f093a78a21a82ed6238de789572498070341906fef2e34101e9b99d3b10f0633382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a150565b60078054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110b75780601f1061108c576101008083540402835291602001916110b7565b820191906000526020600020905b81548152906001019060200180831161109a57829003601f168201915b505050505081565b60088054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156111555780601f1061112a57610100808354040283529160200191611155565b820191906000526020600020905b81548152906001019060200180831161113857829003601f168201915b505050505081565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6001818154811061118f57fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b600460149054906101000a900463ffffffff1681565b600660049054906101000a900460030b81565b600660089054906101000a900460030b81565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461125957600080fd5b61126281611308565b50565b6000806000905060008090505b600180549050811015611300573373ffffffffffffffffffffffffffffffffffffffff16600182815481106112a357fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156112f35760019150611300565b8080600101915050611272565b508091505090565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141561134257600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505056fea165627a7a7230582032831e4baf33c0ff794da9b2f5f0dc9140c1c5b000f9ebfee5bb5bc57a5232ae0029";

    protected AssetStatement(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        super(BINARY, contractAddress, citaj, transactionManager);
    }

    public List<AssetStatementEventResponse> getAssetStatementEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("assetStatement", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AssetStatementEventResponse> responses = new ArrayList<AssetStatementEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AssetStatementEventResponse typedResponse = new AssetStatementEventResponse();
            typedResponse._id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._owner = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._creator = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._superAdmin = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AssetStatementEventResponse> assetStatementEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("assetStatement", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, AssetStatementEventResponse>() {
            @Override
            public AssetStatementEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AssetStatementEventResponse typedResponse = new AssetStatementEventResponse();
                typedResponse._id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._owner = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._creator = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._superAdmin = (String) eventValues.getNonIndexedValues().get(3).getValue();
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

    public RemoteCall<String> creator() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("creator", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> statisticalDate() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("statisticalDate", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> checkIsMyUser(String user) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("checkIsMyUser", 
                Arrays.<Type>asList(new Address(user)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> changeLifecycle(BigInteger _lifecycle, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "changeLifecycle",
                Arrays.<Type>asList(new Uint256(_lifecycle)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<BigInteger> stockAmount() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("stockAmount",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple9<BigInteger, BigInteger, String, BigInteger, BigInteger, BigInteger, String, String, String>> getAssetInfo() {
        final com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("getAssetInfo",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}, new TypeReference<Int32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Int32>() {}, new TypeReference<Int32>() {}, new TypeReference<Int32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple9<BigInteger, BigInteger, String, BigInteger, BigInteger, BigInteger, String, String, String>>(
                new Callable<Tuple9<BigInteger, BigInteger, String, BigInteger, BigInteger, BigInteger, String, String, String>>() {
                    @Override
                    public Tuple9<BigInteger, BigInteger, String, BigInteger, BigInteger, BigInteger, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple9<BigInteger, BigInteger, String, BigInteger, BigInteger, BigInteger, String, String, String>(
                                (BigInteger) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue(),
                                (String) results.get(2).getValue(),
                                (BigInteger) results.get(3).getValue(),
                                (BigInteger) results.get(4).getValue(),
                                (BigInteger) results.get(5).getValue(),
                                (String) results.get(6).getValue(),
                                (String) results.get(7).getValue(),
                                (String) results.get(8).getValue());
                    }
                });
    }

    public RemoteCall<String> plantName() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("plantName",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> merchantNo() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("merchantNo",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<String> stockTurnOverRatio() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("stockTurnOverRatio",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> returnRate() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("returnRate",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<BigInteger> id() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("id",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> soldForSettlementAmount() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("soldForSettlementAmount",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> settledForPaymentAmount() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("settledForPaymentAmount",
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "transferOwnership",
                Arrays.<Type>asList(new Address(_newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public static RemoteCall<AssetStatement> deploy(CITAj citaj, TransactionManager transactionManager, Long quota, String nonce, Long validUntilBlock, Integer version, String value, BigInteger chainId, BigInteger _id, BigInteger _merchantNo, String _plantName, BigInteger _stockAmount, BigInteger _soldForSettlementAmount, BigInteger _settledForPaymentAmount, String _stockTurnOverRatio, String _returnRate, String _statisticalDate, String _superAdmin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint32(_id),
                new Int32(_merchantNo),
                new Utf8String(_plantName),
                new Int32(_stockAmount),
                new Int32(_soldForSettlementAmount),
                new Int32(_settledForPaymentAmount),
                new Utf8String(_stockTurnOverRatio),
                new Utf8String(_returnRate),
                new Utf8String(_statisticalDate),
                new Address(_superAdmin)));
        return deployRemoteCall(AssetStatement.class, citaj, transactionManager, quota, nonce, validUntilBlock, version, chainId, value, BINARY, encodedConstructor);
    }

    public static AssetStatement load(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        return new AssetStatement(contractAddress, citaj, transactionManager);
    }

    public static class AssetStatementEventResponse {
        public BigInteger _id;

        public String _owner;

        public String _creator;

        public String _superAdmin;
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
