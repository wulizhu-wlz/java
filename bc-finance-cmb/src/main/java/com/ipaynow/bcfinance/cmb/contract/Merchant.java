package com.ipaynow.bcfinance.cmb.contract;

import com.cryptape.cita.abi.EventEncoder;
import com.cryptape.cita.abi.EventValues;
import com.cryptape.cita.abi.FunctionEncoder;
import com.cryptape.cita.abi.TypeReference;
import com.cryptape.cita.abi.datatypes.Address;
import com.cryptape.cita.abi.datatypes.Bool;
import com.cryptape.cita.abi.datatypes.Event;
import com.cryptape.cita.abi.datatypes.Type;
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
public class Merchant extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051602080610cf48339810180604052602081101561003057600080fd5b8101908080519060200190929190505050806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050610c63806100916000396000f3fe60806040526004361061005c576000357c0100000000000000000000000000000000000000000000000000000000900480634cb75d28146100615780635bde8197146101e057806399ec372a146102c8578063a6526b4e14610351575b600080fd5b34801561006d57600080fd5b506101de6004803603606081101561008457600080fd5b81019080803590602001906401000000008111156100a157600080fd5b8201836020820111156100b357600080fd5b803590602001918460018302840111640100000000831117156100d557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019064010000000081111561015857600080fd5b82018360208201111561016a57600080fd5b8035906020019184600183028401116401000000008311171561018c57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506103a8565b005b3480156101ec57600080fd5b506102c66004803603604081101561020357600080fd5b810190808035906020019064010000000081111561022057600080fd5b82018360208201111561023257600080fd5b8035906020019184600183028401116401000000008311171561025457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a6c565b005b3480156102d457600080fd5b50610337600480360360408110156102eb57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b75565b604051808215151515815260200191505060405180910390f35b34801561035d57600080fd5b50610366610c0e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561040357600080fd5b600073ffffffffffffffffffffffffffffffffffffffff166002826040518082805190602001908083835b602083101515610453578051825260208201915060208101905060208303925061042e565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515156104ca57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff166001846040518082805190602001908083835b60208310151561051a57805182526020820191506020810190506020830392506104f5565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561063957816001846040518082805190602001908083835b6020831015156105c3578051825260208201915060208101905060208303925061059e565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555061078e565b8173ffffffffffffffffffffffffffffffffffffffff166001846040518082805190602001908083835b6020831015156106885780518252602082019150602081019050602083039250610663565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561078d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602a8152602001807fe59586e688b7e5b7b2e5ad98e59ca8efbc8ce4b8946d65726368616e7441646481526020017f72e4b88de79bb8e7ad890000000000000000000000000000000000000000000081525060400191505060405180910390fd5b5b60006002826040518082805190602001908083835b6020831015156107c857805182526020820191506020810190506020830392506107a3565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690506000600360008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020905060018160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055507f034c0c617b35528bfb256e420ec79ab46317e50ad27420e175dd67b5e2f5e0216001866040518082805190602001908083835b60208310151561091157805182526020820191506020810190506020830392506108ec565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166002856040518082805190602001908083835b60208310151561099d5780518252602082019150602081019050602083039250610978565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a15050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610ac757600080fd5b806002836040518082805190602001908083835b602083101515610b005780518252602082019150602081019050602083039250610adb565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050565b600080600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1691505092915050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690509056fea165627a7a723058203cee8477db8a0beb1a2483571c1cf0e140c357d92fc0c6f76c96ee49de8f40a30029";

    protected Merchant(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        super(BINARY, contractAddress, citaj, transactionManager);
    }

    public List<AddEventEventResponse> getAddEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("addEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AddEventEventResponse> responses = new ArrayList<AddEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AddEventEventResponse typedResponse = new AddEventEventResponse();
            typedResponse.merchants = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.platforms = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddEventEventResponse> addEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("addEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, AddEventEventResponse>() {
            @Override
            public AddEventEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AddEventEventResponse typedResponse = new AddEventEventResponse();
                typedResponse.merchants = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.platforms = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> add(String merchantId, String merchantAddr, String platformId, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "add", 
                Arrays.<Type>asList(new com.cryptape.cita.abi.datatypes.Utf8String(merchantId), 
                new Address(merchantAddr),
                new com.cryptape.cita.abi.datatypes.Utf8String(platformId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> addPlatform(String platformId, String platformAddr, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "addPlatform", 
                Arrays.<Type>asList(new com.cryptape.cita.abi.datatypes.Utf8String(platformId), 
                new Address(platformAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<Boolean> isExists(String merchantAddr, String platformAddr) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("isExists", 
                Arrays.<Type>asList(new Address(merchantAddr),
                new Address(platformAddr)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> queryAdmin() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("queryAdmin", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<Merchant> deploy(CITAj citaj, TransactionManager transactionManager, Long quota, String nonce, Long validUntilBlock, Integer version, String value, BigInteger chainId, String adminAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(adminAddress)));
        return deployRemoteCall(Merchant.class, citaj, transactionManager, quota, nonce, validUntilBlock, version, chainId, value, BINARY, encodedConstructor);
    }

    public static Merchant load(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        return new Merchant(contractAddress, citaj, transactionManager);
    }

    public static class AddEventEventResponse {
        public String merchants;

        public String platforms;
    }
}
