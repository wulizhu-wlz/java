package com.ipaynow.bcfinance.cmb.contract;

import com.cryptape.cita.abi.EventEncoder;
import com.cryptape.cita.abi.EventValues;
import com.cryptape.cita.abi.FunctionEncoder;
import com.cryptape.cita.abi.TypeReference;
import com.cryptape.cita.abi.datatypes.Address;
import com.cryptape.cita.abi.datatypes.DynamicArray;
import com.cryptape.cita.abi.datatypes.Event;
import com.cryptape.cita.abi.datatypes.Type;
import com.cryptape.cita.abi.datatypes.Utf8String;
import com.cryptape.cita.abi.datatypes.generated.Bytes32;
import com.cryptape.cita.abi.datatypes.generated.Uint8;
import com.cryptape.cita.protocol.CITAj;
import com.cryptape.cita.protocol.core.DefaultBlockParameter;
import com.cryptape.cita.protocol.core.RemoteCall;
import com.cryptape.cita.protocol.core.methods.request.AppFilter;
import com.cryptape.cita.protocol.core.methods.response.Log;
import com.cryptape.cita.protocol.core.methods.response.TransactionReceipt;
import com.cryptape.cita.tuples.generated.Tuple2;
import com.cryptape.cita.tuples.generated.Tuple4;
import com.cryptape.cita.tuples.generated.Tuple6;
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
public class Financial extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516020806122278339810180604052602081101561003057600080fd5b8101908080519060200190929190505050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415151561007d57600080fd5b80600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050612159806100ce6000396000f3fe608060405260043610610088576000357c0100000000000000000000000000000000000000000000000000000000900480632dbf41a01461008d578063390ca6c3146101f25780633cd5feff146103175780633da5276c146103a757806350ae51fa1461043757806394ad3f5314610594578063c7cda6ee14610742578063cfb5192814610812575b600080fd5b34801561009957600080fd5b50610153600480360360208110156100b057600080fd5b81019080803590602001906401000000008111156100cd57600080fd5b8201836020820111156100df57600080fd5b8035906020019184600183028401116401000000008311171561010157600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506108ee565b604051808060200180602001838103835285818151815260200191508051906020019060200280838360005b8381101561019a57808201518184015260208101905061017f565b50505050905001838103825284818151815260200191508051906020019060200280838360005b838110156101dc5780820151818401526020810190506101c1565b5050505090500194505050505060405180910390f35b3480156101fe57600080fd5b50610315600480360360a081101561021557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019064010000000081111561027257600080fd5b82018360208201111561028457600080fd5b803590602001918460018302840111640100000000831117156102a657600080fd5b9091929391929390803590602001906401000000008111156102c757600080fd5b8201836020820111156102d957600080fd5b803590602001918460018302840111640100000000831117156102fb57600080fd5b909192939192939080359060200190929190505050610d23565b005b34801561032357600080fd5b506103a56004803603604081101561033a57600080fd5b810190808035906020019064010000000081111561035757600080fd5b82018360208201111561036957600080fd5b8035906020019184600183028401116401000000008311171561038b57600080fd5b909192939192939080359060200190929190505050611354565b005b3480156103b357600080fd5b50610435600480360360408110156103ca57600080fd5b81019080803590602001906401000000008111156103e757600080fd5b8201836020820111156103f957600080fd5b8035906020019184600183028401116401000000008311171561041b57600080fd5b9091929391929390803590602001909291905050506115e0565b005b34801561044357600080fd5b506104fd6004803603602081101561045a57600080fd5b810190808035906020019064010000000081111561047757600080fd5b82018360208201111561048957600080fd5b803590602001918460018302840111640100000000831117156104ab57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506117dd565b604051808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018581526020018481526020018381526020018260ff1660ff168152602001965050505050505060405180910390f35b3480156105a057600080fd5b5061065a600480360360208110156105b757600080fd5b81019080803590602001906401000000008111156105d457600080fd5b8201836020820111156105e657600080fd5b8035906020019184600183028401116401000000008311171561060857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611982565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001838152602001828103825284818151815260200191508051906020019080838360005b838110156107045780820151818401526020810190506106e9565b50505050905090810190601f1680156107315780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561074e57600080fd5b506108106004803603608081101561076557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001906401000000008111156107c257600080fd5b8201836020820111156107d457600080fd5b803590602001918460018302840111640100000000831117156107f657600080fd5b909192939192939080359060200190929190505050611b86565b005b34801561081e57600080fd5b506108d86004803603602081101561083557600080fd5b810190808035906020019064010000000081111561085257600080fd5b82018360208201111561086457600080fd5b8035906020019184600183028401116401000000008311171561088657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611f15565b6040518082815260200191505060405180910390f35b60608060606002846040518082805190602001908083835b60208310151561092b5780518252602082019150602081019050602083039250610906565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020805480602002602001604051908101604052809291908181526020016000905b82821015610a3a578382906000526020600020018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a265780601f106109fb57610100808354040283529160200191610a26565b820191906000526020600020905b815481529060010190602001808311610a0957829003601f168201915b50505050508152602001906001019061097e565b50505050905060608151604051908082528060200260200182016040528015610a725781602001602082028038833980820191505090505b50905060608251604051908082528060200260200182016040528015610aa75781602001602082028038833980820191505090505b50905060008090505b8351811015610d1457610ad98482815181101515610aca57fe5b90602001906020020151611f15565b8282815181101515610ae757fe5b9060200190602002018181525050610afd611f41565b60018583815181101515610b0d57fe5b906020019060200201516040518082805190602001908083835b602083101515610b4c5780518252602082019150602081019050602083039250610b27565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020608060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160028201548152602001600382018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610cda5780601f10610caf57610100808354040283529160200191610cda565b820191906000526020600020905b815481529060010190602001808311610cbd57829003601f168201915b505050505081525050905080604001518483815181101515610cf857fe5b9060200190602002018181525050508080600101915050610ab0565b50808294509450505050915091565b60006001026000868660405180838380828437808301925050509250505090815260200160405180910390206004015414151515610dc9576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601a8152602001807fe89e8de8b584e8aeb0e5bd956c6f616e48617368e4b8bae7a9ba00000000000081525060200191505060405180910390fd5b8573ffffffffffffffffffffffffffffffffffffffff1660008686604051808383808284378083019250505092505050908152602001604051809103902060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148015610ec357508673ffffffffffffffffffffffffffffffffffffffff1660008686604051808383808284378083019250505092505050908152602001604051809103902060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b1515610f5d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602c8152602001807f6372656469746f72e5928c646562746f72e99c80e8a681e4b88ee993bee4b88a81526020017fe695b0e68daee4b880e887b4000000000000000000000000000000000000000081525060400191505060405180910390fd5b600060010260018484604051808383808284378083019250505092505050908152602001604051809103902060020154141561117c57610f9b611f41565b6080604051908101604052808973ffffffffffffffffffffffffffffffffffffffff1681526020018873ffffffffffffffffffffffffffffffffffffffff16815260200183815260200187878080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050508152509050600286866040518083838082843780830192505050925050509081526020016040518091039020848490918060018154018082558091505090600182039060005260206000200160009091929390919293909192909192509190611094929190611f99565b50508060018585604051808383808284378083019250505092505050908152602001604051809103902060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550604082015181600201556060820151816003019080519060200190611172929190612019565b5090505050611244565b8060018484604051808383808284378083019250505092505050908152602001604051809103902060020154141515611243576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260318152602001807fe8bf98e6acbee8aeb0e5bd95e5b7b2e5ad98e59ca8efbc8ce4b89468617368e481526020017fb88ee585a5e58f82e4b88de79bb8e7ad8900000000000000000000000000000081525060400191505060405180910390fd5b5b7f3be4ef0754377ec8681a2bdeb5609fc250f026177189de926e54a683c90e795287878787878787604051808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001806020018481526020018381038352888882818152602001925080828437600081840152601f19601f8201169050808301925050508381038252868682818152602001925080828437600081840152601f19601f820116905080830192505050995050505050505050505060405180910390a150505050505050565b600060010260008484604051808383808284378083019250505092505050908152602001604051809103902060030154141515156113fa576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601f8152602001807fe89e8de8b584e8aeb0e5bd95e79a8461636365707448617368e4b8bae7a9ba0081525060200191505060405180910390fd5b60006001026000848460405180838380828437808301925050509250505090815260200160405180910390206004015414156114a8578060008484604051808383808284378083019250505092505050908152602001604051809103902060040181905550600260008484604051808383808284378083019250505092505050908152602001604051809103902060050160006101000a81548160ff021916908360ff160217905550611570565b806000848460405180838380828437808301925050509250505090815260200160405180910390206004015414151561156f576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260318152602001807fe694bee6acbee8aeb0e5bd95e5b7b2e5ad98e59ca8efbc8ce4b8946c6f616e4881526020017f61736820213d20e585a5e58f826861736800000000000000000000000000000081525060400191505060405180910390fd5b5b7f5bde5b86e02c38f2f7c843622abddb12fa02cc9ef79589ab9da769a81d94509b83838360405180806020018381526020018281038252858582818152602001925080828437600081840152601f19601f82011690508083019250505094505050505060405180910390a1505050565b60006001026000848460405180838380828437808301925050509250505090815260200160405180910390206002015414151515611686576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601b8152602001807fe89e8de8b584e8aeb0e5bd956170706c7948617368e4b8bae7a9ba000000000081525060200191505060405180910390fd5b6000600102600084846040518083838082843780830192505050925050509081526020016040518091039020600301541415611734578060008484604051808383808284378083019250505092505050908152602001604051809103902060030181905550600160008484604051808383808284378083019250505092505050908152602001604051809103902060050160006101000a81548160ff021916908360ff16021790555061176d565b806000848460405180838380828437808301925050509250505090815260200160405180910390206003015414151561176c57600080fd5b5b7f5bde5b86e02c38f2f7c843622abddb12fa02cc9ef79589ab9da769a81d94509b83838360405180806020018381526020018281038252858582818152602001925080828437600081840152601f19601f82011690508083019250505094505050505060405180910390a1505050565b6000806000806000806117ee612099565b6000886040518082805190602001908083835b6020831015156118265780518252602082019150602081019050602083039250611801565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060c060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016002820154815260200160038201548152602001600482015481526020016005820160009054906101000a900460ff1660ff1660ff1681525050905080600001519650806020015195508060400151945080606001519350806080015192508060a0015191505091939550919395565b60008060606000611991611f41565b6001866040518082805190602001908083835b6020831015156119c957805182526020820191506020810190506020830392506119a4565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020608060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160028201548152602001600382018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611b575780601f10611b2c57610100808354040283529160200191611b57565b820191906000526020600020905b815481529060010190602001808311611b3a57829003601f168201915b505050505081525050905080600001519450806020015193508060600151925080604001519150509193509193565b600073ffffffffffffffffffffffffffffffffffffffff1660008484604051808383808284378083019250505092505050908152602001604051809103902060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611d7357611c0d612099565b60c0604051908101604052808773ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1681526020018381526020016000600102815260200160006001028152602001600060ff1681525090508060008585604051808383808284378083019250505092505050908152602001604051809103902060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060408201518160020155606082015181600301556080820151816004015560a08201518160050160006101000a81548160ff021916908360ff16021790555090505050611e3b565b8060008484604051808383808284378083019250505092505050908152602001604051809103902060020154141515611e3a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260398152602001807fe89e8de8b584e794b3e8afb7e8aeb0e5bd95e5b7b2e5ad98e59ca8efbc8ce4b881526020017f946163636570744861736820213d20e585a5e58f82686173680000000000000081525060400191505060405180910390fd5b5b7ffb6fcc80ef0dd80d36a2e4bd59cdd54de6036ac7519e5d91ca20a3e49fa54ad98585858585604051808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018381526020018281038252858582818152602001925080828437600081840152601f19601f820116905080830192505050965050505050505060405180910390a15050505050565b60006060829050600081511415611f33576000600102915050611f3c565b60208301519150505b919050565b608060405190810160405280600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff16815260200160008019168152602001606081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611fda57803560ff1916838001178555612008565b82800160010185558215612008579182015b82811115612007578235825591602001919060010190611fec565b5b5090506120159190612108565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061205a57805160ff1916838001178555612088565b82800160010185558215612088579182015b8281111561208757825182559160200191906001019061206c565b5b5090506120959190612108565b5090565b60c060405190810160405280600073ffffffffffffffffffffffffffffffffffffffff168152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600080191681526020016000801916815260200160008019168152602001600060ff1681525090565b61212a91905b8082111561212657600081600090555060010161210e565b5090565b9056fea165627a7a723058204a380c811f7bed8c886467e83fc078fceb5d81ef2604d6afd54ee30b8d0674670029";

    protected Financial(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        super(BINARY, contractAddress, citaj, transactionManager);
    }

    public List<DoApplyEventResponse> getDoApplyEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doApply", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoApplyEventResponse> responses = new ArrayList<DoApplyEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoApplyEventResponse typedResponse = new DoApplyEventResponse();
            typedResponse.debtor = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.creditor = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.loanId = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.hash = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoApplyEventResponse> doApplyEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doApply", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoApplyEventResponse>() {
            @Override
            public DoApplyEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoApplyEventResponse typedResponse = new DoApplyEventResponse();
                typedResponse.debtor = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.creditor = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.loanId = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.hash = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public List<DoAcceptEventResponse> getDoAcceptEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doAccept", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoAcceptEventResponse> responses = new ArrayList<DoAcceptEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoAcceptEventResponse typedResponse = new DoAcceptEventResponse();
            typedResponse.loanId = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.hash = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoAcceptEventResponse> doAcceptEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doAccept", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoAcceptEventResponse>() {
            @Override
            public DoAcceptEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoAcceptEventResponse typedResponse = new DoAcceptEventResponse();
                typedResponse.loanId = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.hash = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<DoLoanEventResponse> getDoLoanEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doLoan", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoLoanEventResponse> responses = new ArrayList<DoLoanEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoLoanEventResponse typedResponse = new DoLoanEventResponse();
            typedResponse.loanId = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.hash = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoLoanEventResponse> doLoanEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doLoan", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoLoanEventResponse>() {
            @Override
            public DoLoanEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoLoanEventResponse typedResponse = new DoLoanEventResponse();
                typedResponse.loanId = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.hash = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<DoRepayEventResponse> getDoRepayEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doRepay", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoRepayEventResponse> responses = new ArrayList<DoRepayEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoRepayEventResponse typedResponse = new DoRepayEventResponse();
            typedResponse.debtor = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.creditor = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.loanId = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.repayId = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.hash = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoRepayEventResponse> doRepayEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doRepay", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoRepayEventResponse>() {
            @Override
            public DoRepayEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoRepayEventResponse typedResponse = new DoRepayEventResponse();
                typedResponse.debtor = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.creditor = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.loanId = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.repayId = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.hash = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public List<DetailMsgEventResponse> getDetailMsgEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("detailMsg", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DetailMsgEventResponse> responses = new ArrayList<DetailMsgEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DetailMsgEventResponse typedResponse = new DetailMsgEventResponse();
            typedResponse.desc = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DetailMsgEventResponse> detailMsgEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("detailMsg", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DetailMsgEventResponse>() {
            @Override
            public DetailMsgEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DetailMsgEventResponse typedResponse = new DetailMsgEventResponse();
                typedResponse.desc = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<Tuple2<List<byte[]>, List<byte[]>>> queryRepayByLoanId(String loanId) {
        final com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("queryRepayByLoanId", 
                Arrays.<Type>asList(new Utf8String(loanId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteCall<Tuple2<List<byte[]>, List<byte[]>>>(
                new Callable<Tuple2<List<byte[]>, List<byte[]>>>() {
                    @Override
                    public Tuple2<List<byte[]>, List<byte[]>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple2<List<byte[]>, List<byte[]>>(
                                convertToNative((List<Bytes32>) results.get(0).getValue()), 
                                convertToNative((List<Bytes32>) results.get(1).getValue()));
                    }
                });
    }

    public RemoteCall<TransactionReceipt> repay(String debtor, String creditor, String loanId, String repayId, byte[] hash, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "repay", 
                Arrays.<Type>asList(new Address(debtor),
                new Address(creditor),
                new Utf8String(loanId),
                new Utf8String(repayId),
                new Bytes32(hash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> loan(String loanId, byte[] hash, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "loan", 
                Arrays.<Type>asList(new Utf8String(loanId),
                new Bytes32(hash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> accept(String loanId, byte[] hash, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "accept", 
                Arrays.<Type>asList(new Utf8String(loanId),
                new Bytes32(hash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<Tuple6<String, String, byte[], byte[], byte[], BigInteger>> queryloan(String loanId) {
        final com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("queryloan", 
                Arrays.<Type>asList(new Utf8String(loanId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint8>() {}));
        return new RemoteCall<Tuple6<String, String, byte[], byte[], byte[], BigInteger>>(
                new Callable<Tuple6<String, String, byte[], byte[], byte[], BigInteger>>() {
                    @Override
                    public Tuple6<String, String, byte[], byte[], byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple6<String, String, byte[], byte[], byte[], BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue(), 
                                (byte[]) results.get(3).getValue(), 
                                (byte[]) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<Tuple4<String, String, String, byte[]>> queryRepay(String repayId) {
        final com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("queryRepay", 
                Arrays.<Type>asList(new Utf8String(repayId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteCall<Tuple4<String, String, String, byte[]>>(
                new Callable<Tuple4<String, String, String, byte[]>>() {
                    @Override
                    public Tuple4<String, String, String, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple4<String, String, String, byte[]>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (byte[]) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> applyFinancing(String debtor, String creditor, String loanId, byte[] hash, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "applyFinancing", 
                Arrays.<Type>asList(new Address(debtor),
                new Address(creditor),
                new Utf8String(loanId),
                new Bytes32(hash)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<byte[]> stringToBytes32(String source) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("stringToBytes32", 
                Arrays.<Type>asList(new Utf8String(source)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public static RemoteCall<Financial> deploy(CITAj citaj, TransactionManager transactionManager, Long quota, String nonce, Long validUntilBlock, Integer version, String value, BigInteger chainId, String contractAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(contractAddr)));
        return deployRemoteCall(Financial.class, citaj, transactionManager, quota, nonce, validUntilBlock, version, chainId, value, BINARY, encodedConstructor);
    }

    public static Financial load(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        return new Financial(contractAddress, citaj, transactionManager);
    }

    public static class DoApplyEventResponse {
        public String debtor;

        public String creditor;

        public String loanId;

        public byte[] hash;
    }

    public static class DoAcceptEventResponse {
        public String loanId;

        public byte[] hash;
    }

    public static class DoLoanEventResponse {
        public String loanId;

        public byte[] hash;
    }

    public static class DoRepayEventResponse {
        public String debtor;

        public String creditor;

        public String loanId;

        public String repayId;

        public byte[] hash;
    }

    public static class DetailMsgEventResponse {
        public String desc;
    }
}
