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
public class AccountFactory extends Contract {
    private static final String BINARY = "6080604052600160025534801561001557600080fd5b5060405161293c38038061293c8339818101604052602081101561003857600080fd5b810190808051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146101005780600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b505061282b806101116000396000f3fe60806040523480156200001157600080fd5b5060043610620000ac5760003560e01c80639b8d40b7116200006f5780639b8d40b714620002e6578063aa03fa3d14620003e7578063ac0cc8681462000458578063f2fde38b1462000478578063fa15b38914620004bf57620000ac565b80634192806f14620000b157806357dfb1cd1462000216578063715018a61462000247578063747293fb14620002535780638da5cb5b146200029a575b600080fd5b6200021460048036036060811015620000c957600080fd5b8101908080359060200190640100000000811115620000e757600080fd5b820183602082011115620000fa57600080fd5b803590602001918460018302840111640100000000831117156200011d57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190929190803590602001906401000000008111156200018b57600080fd5b8201836020820111156200019e57600080fd5b80359060200191846001830284011164010000000083111715620001c157600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929050505062000526565b005b62000245600480360360208110156200022e57600080fd5b810190808035906020019092919050505062000a15565b005b6200025162000ac1565b005b62000298600480360360208110156200026b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505062000bc2565b005b620002a462000d2e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b620003a560048036036020811015620002fe57600080fd5b81019080803590602001906401000000008111156200031c57600080fd5b8201836020820111156200032f57600080fd5b803590602001918460018302840111640100000000831117156200035257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929050505062000d53565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6200041660048036036020811015620003ff57600080fd5b810190808035906020019092919050505062000de8565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6200046262000e25565b6040518082815260200191505060405180910390f35b620004bd600480360360208110156200049057600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505062000e2b565b005b6200052460048036036040811015620004d757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505062000e93565b005b600073ffffffffffffffffffffffffffffffffffffffff166004846040518082805190602001908083835b6020831062000576578051825260208201915060208101905060208303925062000551565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161462000735576004836040518082805190602001908083835b602083106200061e5780518252602082019150602081019050602083039250620005f9565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167fadc425c29947db53ffd80af98fc6708fdf55f209e68ca29e640b1bdc0f177cd984426040518080602001838152602001828103825284818151815260200191508051906020019080838360005b83811015620006f3578082015181840152602081019050620006d6565b50505050905090810190601f168015620007215780820380516001836020036101000a031916815260200191505b50935050505060405180910390a262000a10565b6000838383600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040516200076b9062001311565b8080602001858152602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835287818151815260200191508051906020019080838360005b83811015620007e6578082015181840152602081019050620007c9565b50505050905090810190601f168015620008145780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156200084f57808201518184015260208101905062000832565b50505050905090810190601f1680156200087d5780820380516001836020036101000a031916815260200191505b509650505050505050604051809103906000f080158015620008a3573d6000803e3d6000fd5b509050806004856040518082805190602001908083835b60208310620008df5780518252602082019150602081019050602083039250620008ba565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508073ffffffffffffffffffffffffffffffffffffffff167fadc425c29947db53ffd80af98fc6708fdf55f209e68ca29e640b1bdc0f177cd985426040518080602001838152602001828103825284818151815260200191508051906020019080838360005b83811015620009d2578082015181840152602081019050620009b5565b50505050905090810190601f16801562000a005780820380516001836020036101000a031916815260200191505b50935050505060405180910390a2505b505050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161462000a7057600080fd5b806002819055503373ffffffffffffffffffffffffffffffffffffffff16816002547f06d0981ddf88b524abcd78795702af5c17e6616ceb8eb4aa2b47db576d7a912060405160405180910390a450565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161462000b1b57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482060405160405180910390a260008060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b62000bcc62001170565b8062000c2457506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b62000c2e57600080fd5b60018190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f1f093a78a21a82ed6238de789572498070341906fef2e34101e9b99d3b10f0633382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a150565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60006004826040518082805190602001908083835b6020831062000d8d578051825260208201915060208101905060208303925062000d68565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6001818154811062000df657fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161462000e8557600080fd5b62000e908162001218565b50565b600082905060008290508073ffffffffffffffffffffffffffffffffffffffff16631d655c59336040518263ffffffff1660e01b8152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060206040518083038186803b15801562000f1b57600080fd5b505afa15801562000f30573d6000803e3d6000fd5b505050506040513d602081101562000f4757600080fd5b810190808051906020019092919050505062000f6257600080fd5b8173ffffffffffffffffffffffffffffffffffffffff16636f0735fb60016040518263ffffffff1660e01b815260040180828152602001915050600060405180830381600087803b15801562000fb757600080fd5b505af115801562000fcc573d6000803e3d6000fd5b505050508373ffffffffffffffffffffffffffffffffffffffff167fa0c1de8a7b7dd646de9feff2cbde36f3386c564d156a9e390a694cbf93d747728373ffffffffffffffffffffffffffffffffffffffff166396964a226040518163ffffffff1660e01b815260040160006040518083038186803b1580156200104f57600080fd5b505afa15801562001064573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f8201168201806040525060208110156200108f57600080fd5b810190808051640100000000811115620010a857600080fd5b82810190506020810184811115620010bf57600080fd5b8151856001820283011164010000000082111715620010dd57600080fd5b5050929190505050426040518080602001838152602001828103825284818151815260200191508051906020019080838360005b838110156200112e57808201518184015260208101905062001111565b50505050905090810190601f1680156200115c5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a250505050565b6000806000905060008090505b60018054905081101562001210573373ffffffffffffffffffffffffffffffffffffffff1660018281548110620011b057fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141562001202576001915062001210565b80806001019150506200117d565b508091505090565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156200125357600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6114d780620013208339019056fe608060405260016002553480156200001657600080fd5b50604051620014d7380380620014d7833981810160405260808110156200003c57600080fd5b8101908080516401000000008111156200005557600080fd5b828101905060208101848111156200006c57600080fd5b81518560018202830111640100000000821117156200008a57600080fd5b5050929190602001805190602001909291908051640100000000811115620000b157600080fd5b82810190506020810184811115620000c857600080fd5b8151856001820283011164010000000082111715620000e657600080fd5b50509291906020018051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614620001b35780600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50326000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555033600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060013390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550508360059080519060200190620002b3929190620002e6565b50826006819055508160079080519060200190620002d3929190620002e6565b5060006008819055505050505062000395565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200032957805160ff19168380011785556200035a565b828001600101855582156200035a579182015b82811115620003595782518255916020019190600101906200033c565b5b5090506200036991906200036d565b5090565b6200039291905b808211156200038e57600081600090555060010162000374565b5090565b90565b61113280620003a56000396000f3fe608060405234801561001057600080fd5b50600436106101005760003560e01c8063747293fb11610097578063ac0cc86811610066578063ac0cc86814610527578063c6a992e514610545578063f2fde38b14610563578063fbce2546146105a757610100565b8063747293fb146103a85780638da5cb5b146103ec57806396964a2214610436578063aa03fa3d146104b957610100565b806357dfb1cd116100d357806357dfb1cd146102bf5780636f0735fb146102ed578063715018a61461031b578063740aa2ea1461032557610100565b806302d05d3f146101055780631b9e16ad1461014f5780631d655c59146102455780631e3b70b4146102a1575b600080fd5b61010d610662565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610157610688565b604051808060200184815260200180602001838103835286818151815260200191508051906020019080838360005b838110156101a1578082015181840152602081019050610186565b50505050905090810190601f1680156101ce5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156102075780820151818401526020810190506101ec565b50505050905090810190601f1680156102345780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b6102876004803603602081101561025b57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506107d8565b604051808215151515815260200191505060405180910390f35b6102a9610831565b6040518082815260200191505060405180910390f35b6102eb600480360360208110156102d557600080fd5b8101908080359060200190929190505050610837565b005b6103196004803603602081101561030357600080fd5b81019080803590602001909291905050506108e2565b005b6103236108ec565b005b61032d6109ec565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561036d578082015181840152602081019050610352565b50505050905090810190601f16801561039a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6103ea600480360360208110156103be57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a8a565b005b6103f4610bf2565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61043e610c17565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561047e578082015181840152602081019050610463565b50505050905090810190601f1680156104ab5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6104e5600480360360208110156104cf57600080fd5b8101908080359060200190929190505050610cb5565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61052f610cf1565b6040518082815260200191505060405180910390f35b61054d610cf7565b6040518082815260200191505060405180910390f35b6105a56004803603602081101561057957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610cfd565b005b610660600480360360208110156105bd57600080fd5b81019080803590602001906401000000008111156105da57600080fd5b8201836020820111156105ec57600080fd5b8035906020019184600183028401116401000000008311171561060e57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610d62565b005b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60606000606060056006546007828054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561072a5780601f106106ff5761010080835404028352916020019161072a565b820191906000526020600020905b81548152906001019060200180831161070d57829003601f168201915b50505050509250808054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107c65780601f1061079b576101008083540402835291602001916107c6565b820191906000526020600020905b8154815290600101906020018083116107a957829003601f168201915b50505050509050925092509250909192565b60008173ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16149050919050565b60065481565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161461089157600080fd5b806002819055503373ffffffffffffffffffffffffffffffffffffffff16816002547f06d0981ddf88b524abcd78795702af5c17e6616ceb8eb4aa2b47db576d7a912060405160405180910390a450565b8060088190555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461094557600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482060405160405180910390a260008060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b60078054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a825780601f10610a5757610100808354040283529160200191610a82565b820191906000526020600020905b815481529060010190602001808311610a6557829003601f168201915b505050505081565b610a92610ebd565b80610ae957506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b610af257600080fd5b60018190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f1f093a78a21a82ed6238de789572498070341906fef2e34101e9b99d3b10f0633382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a150565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60058054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610cad5780601f10610c8257610100808354040283529160200191610cad565b820191906000526020600020905b815481529060010190602001808311610c9057829003601f168201915b505050505081565b60018181548110610cc257fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b60085481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610d5657600080fd5b610d5f81610f60565b50565b610d6b336107d8565b610d7457600080fd5b8060079080519060200190610d8a929190611058565b507f1bf775db9b0b1c41d949b4279cf2e6003b92fb80cb6760412e1f846c2a9d388360058242604051808060200180602001848152602001838103835286818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015610e435780601f10610e1857610100808354040283529160200191610e43565b820191906000526020600020905b815481529060010190602001808311610e2657829003601f168201915b5050838103825285818151815260200191508051906020019080838360005b83811015610e7d578082015181840152602081019050610e62565b50505050905090810190601f168015610eaa5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a150565b6000806000905060008090505b600180549050811015610f58573373ffffffffffffffffffffffffffffffffffffffff1660018281548110610efb57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610f4b5760019150610f58565b8080600101915050610eca565b508091505090565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415610f9a57600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061109957805160ff19168380011785556110c7565b828001600101855582156110c7579182015b828111156110c65782518255916020019190600101906110ab565b5b5090506110d491906110d8565b5090565b6110fa91905b808211156110f65760008160009055506001016110de565b5090565b9056fea265627a7a723058202f74a0f7c0057070f847cd15902f86d0b3988bf38a71a4b2f29ea8fd53540ccc64736f6c63430005090032a265627a7a72305820bc3a0750d62afaeeac1df8faa43d9e8feb3e192cca5a7bfc6cf88d260ac3bef864736f6c63430005090032";

    protected AccountFactory(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        super(BINARY, contractAddress, citaj, transactionManager);
    }

    public List<AccountContractCreatedEventResponse> getAccountContractCreatedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("AccountContractCreated", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AccountContractCreatedEventResponse> responses = new ArrayList<AccountContractCreatedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AccountContractCreatedEventResponse typedResponse = new AccountContractCreatedEventResponse();
            typedResponse.accountAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.id = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.openTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AccountContractCreatedEventResponse> accountContractCreatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("AccountContractCreated", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, AccountContractCreatedEventResponse>() {
            @Override
            public AccountContractCreatedEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AccountContractCreatedEventResponse typedResponse = new AccountContractCreatedEventResponse();
                typedResponse.accountAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.id = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.openTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<AccountOpenedEventResponse> getAccountOpenedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("AccountOpened", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AccountOpenedEventResponse> responses = new ArrayList<AccountOpenedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AccountOpenedEventResponse typedResponse = new AccountOpenedEventResponse();
            typedResponse.accountAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.id = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.openTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AccountOpenedEventResponse> accountOpenedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("AccountOpened", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, AccountOpenedEventResponse>() {
            @Override
            public AccountOpenedEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AccountOpenedEventResponse typedResponse = new AccountOpenedEventResponse();
                typedResponse.accountAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.id = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.openTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
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

    public RemoteCall<TransactionReceipt> createAccount(String _id, BigInteger _type, String _name, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "createAccount", 
                Arrays.<Type>asList(new Utf8String(_id),
                new Uint256(_type),
                new Utf8String(_name)),
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

    public RemoteCall<String> getAccountAddr(String _id) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("getAccountAddr", 
                Arrays.<Type>asList(new Utf8String(_id)),
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

    public RemoteCall<TransactionReceipt> transferOwnership(String _newOwner, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "transferOwnership", 
                Arrays.<Type>asList(new Address(_newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> openAccount(String _accountAddr, String _accountPlatformAddr, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "openAccount", 
                Arrays.<Type>asList(new Address(_accountAddr),
                new Address(_accountPlatformAddr)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public static RemoteCall<AccountFactory> deploy(CITAj citaj, TransactionManager transactionManager, Long quota, String nonce, Long validUntilBlock, Integer version, String value, BigInteger chainId, String _superAdmin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_superAdmin)));
        return deployRemoteCall(AccountFactory.class, citaj, transactionManager, quota, nonce, validUntilBlock, version, chainId, value, BINARY, encodedConstructor);
    }

    public static AccountFactory load(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        return new AccountFactory(contractAddress, citaj, transactionManager);
    }

    public static class AccountContractCreatedEventResponse {
        public String accountAddr;

        public String id;

        public BigInteger openTime;
    }

    public static class AccountOpenedEventResponse {
        public String accountAddr;

        public String id;

        public BigInteger openTime;
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
