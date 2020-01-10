package com.ipaynow.bcfinance.chain.contract;

import com.cryptape.cita.abi.EventEncoder;
import com.cryptape.cita.abi.EventValues;
import com.cryptape.cita.abi.FunctionEncoder;
import com.cryptape.cita.abi.TypeReference;
import com.cryptape.cita.abi.datatypes.Address;
import com.cryptape.cita.abi.datatypes.Bool;
import com.cryptape.cita.abi.datatypes.DynamicArray;
import com.cryptape.cita.abi.datatypes.Event;
import com.cryptape.cita.abi.datatypes.Type;
import com.cryptape.cita.abi.datatypes.generated.Uint128;
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
public class FinanceRepayToken extends Contract {
    private static final String BINARY = "60806040523480156200001157600080fd5b50604051620030ef380380620030ef833981810160405260208110156200003757600080fd5b8101908080519060200190929190505050620000606301ffc9a760e01b620000fe60201b60201c565b620000786380ac58cd60e01b620000fe60201b60201c565b33600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550806006819055507fd9d59504b9ecfae37c8751a9b129f29968201855e1e5bcc1deeba3e04cd4335d816040518082815260200191505060405180910390a15062000207565b63ffffffff60e01b817bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614156200019b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f4552433136353a20696e76616c696420696e746572666163652069640000000081525060200191505060405180910390fd5b6001600080837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b612ed880620002176000396000f3fe608060405234801561001057600080fd5b506004361061010b5760003560e01c80636352211e116100a25780638da5cb5b116100715780638da5cb5b14610685578063a22cb465146106cf578063b88d4fde1461071f578063e985e9c514610824578063f2fde38b146108a05761010b565b80636352211e1461054457806370a08231146105b2578063715018a61461060a5780638ce2cf5a146106145761010b565b80631f4a2063116100de5780631f4a2063146103e757806323b872dd1461044657806342842e0e146104b45780634d232d29146105225761010b565b806301ffc9a714610110578063081812fc14610175578063095ea7b3146101e3578063181c022a14610231575b600080fd5b61015b6004803603602081101561012657600080fd5b8101908080357bffffffffffffffffffffffffffffffffffffffffffffffffffffffff191690602001909291905050506108e4565b604051808215151515815260200191505060405180910390f35b6101a16004803603602081101561018b57600080fd5b810190808035906020019092919050505061094b565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61022f600480360360408110156101f957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506109e6565b005b6103e5600480360361010081101561024857600080fd5b8101908080356fffffffffffffffffffffffffffffffff16906020019092919080356fffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190803560ff169060200190929190803590602001906401000000008111156102c857600080fd5b8201836020820111156102da57600080fd5b803590602001918460018302840111640100000000831117156102fc57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561035f57600080fd5b82018360208201111561037157600080fd5b8035906020019184600183028401116401000000008311171561039357600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050610bbf565b005b6103ef611004565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610432578082015181840152602081019050610417565b505050509050019250505060405180910390f35b6104b26004803603606081101561045c57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611092565b005b610520600480360360608110156104ca57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611101565b005b61052a611121565b604051808215151515815260200191505060405180910390f35b6105706004803603602081101561055a57600080fd5b810190808035906020019092919050505061113e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6105f4600480360360208110156105c857600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611206565b6040518082815260200191505060405180910390f35b6106126112db565b005b6106436004803603602081101561062a57600080fd5b81019080803560ff1690602001909291905050506113de565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61068d61149c565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61071d600480360360408110156106e557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035151590602001909291905050506114c2565b005b6108226004803603608081101561073557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019064010000000081111561079c57600080fd5b8201836020820111156107ae57600080fd5b803590602001918460018302840111640100000000831117156107d057600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290505050611665565b005b6108866004803603604081101561083a57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506116d7565b604051808215151515815260200191505060405180910390f35b6108e2600480360360208110156108b657600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061176b565b005b6000806000837bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19167bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916815260200190815260200160002060009054906101000a900460ff169050919050565b6000610956826117d1565b6109ab576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602c815260200180612dfd602c913960400191505060405180910390fd5b6002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60006109f18261113e565b90508073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161415610a78576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526021815260200180612e526021913960400191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161480610ab85750610ab781336116d7565b5b610b0d576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526038815260200180612d726038913960400191505060405180910390fd5b826002600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550818373ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a4505050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610c1957600080fd5b600087604051610c28906122b6565b80826fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff168152602001915050604051809103906000f080158015610c72573d6000803e3d6000fd5b5090508073ffffffffffffffffffffffffffffffffffffffff1663eec992228a8a8a8a8a8a8a8a6040518963ffffffff1660e01b815260040180896fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff168152602001886fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff1681526020018781526020018681526020018581526020018460ff1660ff1681526020018060200180602001838103835285818151815260200191508051906020019080838360005b83811015610d5e578082015181840152602081019050610d43565b50505050905090810190601f168015610d8b5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015610dc4578082015181840152602081019050610da9565b50505050905090810190601f168015610df15780820380516001836020036101000a031916815260200191505b509a5050505050505050505050600060405180830381600087803b158015610e1857600080fd5b505af1158015610e2c573d6000803e3d6000fd5b50505050600a60008154809291906001019190505550600b8190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050610ec433896fffffffffffffffffffffffffffffffff16611843565b610ed987600754611a5b90919063ffffffff16565b600781905550610ef486600854611a5b90919063ffffffff16565b600881905550610f0f85600954611a5b90919063ffffffff16565b6009819055506008546006541415610f3e576001600c60006101000a81548160ff021916908360ff1602179055505b7f1bfddd16d429221a9894bfc7a4ff4ce2a0ff827b2bcc8c009cc28f083085324889898360405180846fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff168152602001836fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001935050505060405180910390a1505050505050505050565b6060600b80548060200260200160405190810160405280929190818152602001828054801561108857602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001906001019080831161103e575b5050505050905090565b61109c3382611ae3565b6110f1576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526031815260200180612e736031913960400191505060405180910390fd5b6110fc838383611bd7565b505050565b61111c83838360405180602001604052806000815250611665565b505050565b60006001600c60009054906101000a900460ff1660ff1614905090565b6000806001600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156111fd576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526029815260200180612dd46029913960400191505060405180910390fd5b80915050919050565b60008073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16141561128d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602a815260200180612daa602a913960400191505060405180910390fd5b6112d4600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020611e32565b9050919050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461133557600080fd5b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482060405160405180910390a26000600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b6000600a548260ff161061145a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601b8152602001807f5f696e646578206d6f7265207468616e20726570617954696d6573000000000081525060200191505060405180910390fd5b600b8260ff168154811061146a57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b3373ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415611564576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4552433732313a20617070726f766520746f2063616c6c65720000000000000081525060200191505060405180910390fd5b80600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c3183604051808215151515815260200191505060405180910390a35050565b611670848484611092565b61167c84848484611e40565b6116d1576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526032815260200180612cf06032913960400191505060405180910390fd5b50505050565b6000600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16905092915050565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146117c557600080fd5b6117ce81612029565b50565b6000806001600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415915050919050565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1614156118e6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f4552433732313a206d696e7420746f20746865207a65726f206164647265737381525060200191505060405180910390fd5b6118ef816117d1565b15611962576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601c8152602001807f4552433732313a20746f6b656e20616c7265616479206d696e7465640000000081525060200191505060405180910390fd5b816001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506119fb600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020612123565b808273ffffffffffffffffffffffffffffffffffffffff16600073ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef60405160405180910390a45050565b600080828401905083811015611ad9576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601b8152602001807f536166654d6174683a206164646974696f6e206f766572666c6f77000000000081525060200191505060405180910390fd5b8091505092915050565b6000611aee826117d1565b611b43576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602c815260200180612d46602c913960400191505060405180910390fd5b6000611b4e8361113e565b90508073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff161480611bbd57508373ffffffffffffffffffffffffffffffffffffffff16611ba58461094b565b73ffffffffffffffffffffffffffffffffffffffff16145b80611bce5750611bcd81856116d7565b5b91505092915050565b8273ffffffffffffffffffffffffffffffffffffffff16611bf78261113e565b73ffffffffffffffffffffffffffffffffffffffff1614611c63576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526029815260200180612e296029913960400191505060405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415611ce9576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526024815260200180612d226024913960400191505060405180910390fd5b611cf281612139565b611d39600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206121f7565b611d80600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020612123565b816001600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550808273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef60405160405180910390a4505050565b600081600001549050919050565b6000611e618473ffffffffffffffffffffffffffffffffffffffff1661221a565b611e6e5760019050612021565b60008473ffffffffffffffffffffffffffffffffffffffff1663150b7a02338887876040518563ffffffff1660e01b8152600401808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b83811015611f49578082015181840152602081019050611f2e565b50505050905090810190601f168015611f765780820380516001836020036101000a031916815260200191505b5095505050505050602060405180830381600087803b158015611f9857600080fd5b505af1158015611fac573d6000803e3d6000fd5b505050506040513d6020811015611fc257600080fd5b8101908080519060200190929190505050905063150b7a0260e01b7bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916817bffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916149150505b949350505050565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141561206357600080fd5b8073ffffffffffffffffffffffffffffffffffffffff16600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a380600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6001816000016000828254019250508190555050565b600073ffffffffffffffffffffffffffffffffffffffff166002600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16146121f45760006002600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b61220f6001826000015461222d90919063ffffffff16565b816000018190555050565b600080823b905060008111915050919050565b6000828211156122a5576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601e8152602001807f536166654d6174683a207375627472616374696f6e206f766572666c6f77000081525060200191505060405180910390fd5b600082840390508091505092915050565b610a2c806122c48339019056fe608060405234801561001057600080fd5b50604051610a2c380380610a2c8339818101604052602081101561003357600080fd5b810190808051906020019092919050505080600060106101000a8154816fffffffffffffffffffffffffffffffff02191690836fffffffffffffffffffffffffffffffff1602179055505061099f8061008d6000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80632e49d78b146100515780634a1460e6146100825780634e69d560146101e9578063eec992221461020d575b600080fd5b6100806004803603602081101561006757600080fd5b81019080803560ff1690602001909291905050506103c3565b005b61008a61041e565b60405180896fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff168152602001886fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff1681526020018781526020018681526020018581526020018460ff1660ff1681526020018060200180602001838103835285818151815260200191508051906020019080838360005b83811015610140578082015181840152602081019050610125565b50505050905090810190601f16801561016d5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156101a657808201518184015260208101905061018b565b50505050905090810190601f1680156101d35780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b6101f16105d0565b604051808260ff1660ff16815260200191505060405180910390f35b6103c1600480360361010081101561022457600080fd5b8101908080356fffffffffffffffffffffffffffffffff16906020019092919080356fffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190803560ff169060200190929190803590602001906401000000008111156102a457600080fd5b8201836020820111156102b657600080fd5b803590602001918460018302840111640100000000831117156102d857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561033b57600080fd5b82018360208201111561034d57600080fd5b8035906020019184600183028401116401000000008311171561036f57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506105e7565b005b80600660006101000a81548160ff021916908360ff1602179055507f56f7a12ae1a242b62ea95882be7d1afedff55d8481a724da808b12575bfc8cca81604051808260ff1660ff16815260200191505060405180910390a150565b6000806000806000806060806000809054906101000a90046fffffffffffffffffffffffffffffffff169750600060109054906101000a90046fffffffffffffffffffffffffffffffff1696506001549550600254945060038054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561050b5780601f106104e05761010080835404028352916020019161050b565b820191906000526020600020905b8154815290600101906020018083116104ee57829003601f168201915b5050505050915060048054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105a85780601f1061057d576101008083540402835291602001916105a8565b820191906000526020600020905b81548152906001019060200180831161058b57829003601f168201915b505050505090506005549350600660009054906101000a900460ff1692509091929394959697565b6000600660009054906101000a900460ff16905090565b866fffffffffffffffffffffffffffffffff16600060109054906101000a90046fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff161461069e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260178152602001807f5f72657061794964206e6f7420636f6e73697374656e7400000000000000000081525060200191505060405180910390fd5b876000806101000a8154816fffffffffffffffffffffffffffffffff02191690836fffffffffffffffffffffffffffffffff160217905550856001819055508460028190555081600390805190602001906106fa9291906108c5565b5080600490805190602001906107119291906108c5565b508360058190555082600660006101000a81548160ff021916908360ff1602179055507f43851b24ad82b0b0abb757af671f26a474026804274204d4e6c5f387d49d1470888888888888888860405180896fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff168152602001886fffffffffffffffffffffffffffffffff166fffffffffffffffffffffffffffffffff1681526020018781526020018681526020018581526020018460ff1660ff1681526020018060200180602001838103835285818151815260200191508051906020019080838360005b838110156108135780820151818401526020810190506107f8565b50505050905090810190601f1680156108405780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b8381101561087957808201518184015260208101905061085e565b50505050905090810190601f1680156108a65780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390a15050505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061090657805160ff1916838001178555610934565b82800160010185558215610934579182015b82811115610933578251825591602001919060010190610918565b5b5090506109419190610945565b5090565b61096791905b8082111561096357600081600090555060010161094b565b5090565b9056fea265627a7a723058206d11c176ad5fb53abc637359ad4325fa0f8d05959378da7314632ad04952321564736f6c634300050900324552433732313a207472616e7366657220746f206e6f6e20455243373231526563656976657220696d706c656d656e7465724552433732313a207472616e7366657220746f20746865207a65726f20616464726573734552433732313a206f70657261746f7220717565727920666f72206e6f6e6578697374656e7420746f6b656e4552433732313a20617070726f76652063616c6c6572206973206e6f74206f776e6572206e6f7220617070726f76656420666f7220616c6c4552433732313a2062616c616e636520717565727920666f7220746865207a65726f20616464726573734552433732313a206f776e657220717565727920666f72206e6f6e6578697374656e7420746f6b656e4552433732313a20617070726f76656420717565727920666f72206e6f6e6578697374656e7420746f6b656e4552433732313a207472616e73666572206f6620746f6b656e2074686174206973206e6f74206f776e4552433732313a20617070726f76616c20746f2063757272656e74206f776e65724552433732313a207472616e736665722063616c6c6572206973206e6f74206f776e6572206e6f7220617070726f766564a265627a7a72305820393d4c9a72fc5c17365fe9201ff74ad39a159123c9949577cd81d9f0a8c058f964736f6c63430005090032";

    protected FinanceRepayToken(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        super(BINARY, contractAddress, citaj, transactionManager);
    }

    public List<DoCreateRepayRecordEventResponse> getDoCreateRepayRecordEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doCreateRepayRecord", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint128>() {}, new TypeReference<Uint128>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoCreateRepayRecordEventResponse> responses = new ArrayList<DoCreateRepayRecordEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoCreateRepayRecordEventResponse typedResponse = new DoCreateRepayRecordEventResponse();
            typedResponse._creditId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._repayId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.recordAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoCreateRepayRecordEventResponse> doCreateRepayRecordEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doCreateRepayRecord", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint128>() {}, new TypeReference<Uint128>() {}, new TypeReference<Address>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoCreateRepayRecordEventResponse>() {
            @Override
            public DoCreateRepayRecordEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoCreateRepayRecordEventResponse typedResponse = new DoCreateRepayRecordEventResponse();
                typedResponse._creditId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._repayId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.recordAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<DoConstructorEventResponse> getDoConstructorEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doConstructor", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoConstructorEventResponse> responses = new ArrayList<DoConstructorEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoConstructorEventResponse typedResponse = new DoConstructorEventResponse();
            typedResponse._shouldRepayTotalAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoConstructorEventResponse> doConstructorEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doConstructor", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoConstructorEventResponse>() {
            @Override
            public DoConstructorEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoConstructorEventResponse typedResponse = new DoConstructorEventResponse();
                typedResponse._shouldRepayTotalAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
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

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}),
                Arrays.<TypeReference<?>>asList());
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}),
                Arrays.<TypeReference<?>>asList());
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ApprovalForAll", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ApprovalForAll", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, ApprovalForAllEventResponse>() {
            @Override
            public ApprovalForAllEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<Boolean> supportsInterface(byte[] interfaceId) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("supportsInterface", 
                Arrays.<Type>asList(new com.cryptape.cita.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> getApproved(BigInteger tokenId) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("getApproved", 
                Arrays.<Type>asList(new Uint256(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String to, BigInteger tokenId, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "approve", 
                Arrays.<Type>asList(new Address(to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> createRepayRecord(BigInteger _creditId, BigInteger _repayId, BigInteger _repayAmount, BigInteger _repayPrinciple, BigInteger _financeRateAmount, BigInteger _status, String _creditorId, String _debtorId, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "createRepayRecord", 
                Arrays.<Type>asList(new Uint128(_creditId),
                new Uint128(_repayId),
                new Uint256(_repayAmount),
                new Uint256(_repayPrinciple),
                new Uint256(_financeRateAmount),
                new com.cryptape.cita.abi.datatypes.generated.Uint8(_status), 
                new com.cryptape.cita.abi.datatypes.Utf8String(_creditorId), 
                new com.cryptape.cita.abi.datatypes.Utf8String(_debtorId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<List> getAllRepayRecords() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("getAllRepayRecords", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function, List.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String from, String to, BigInteger tokenId, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "transferFrom", 
                Arrays.<Type>asList(new Address(from),
                new Address(to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "safeTransferFrom", 
                Arrays.<Type>asList(new Address(from),
                new Address(to),
                new Uint256(tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<Boolean> isPayoff() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("isPayoff", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> ownerOf(BigInteger tokenId) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("ownerOf", 
                Arrays.<Type>asList(new Uint256(tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> balanceOf(String owner) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("balanceOf", 
                Arrays.<Type>asList(new Address(owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> renounceOwnership(Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "renounceOwnership", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<String> getRepayRecord(BigInteger _index) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("getRepayRecord", 
                Arrays.<Type>asList(new com.cryptape.cita.abi.datatypes.generated.Uint8(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setApprovalForAll(String to, Boolean approved, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "setApprovalForAll", 
                Arrays.<Type>asList(new Address(to),
                new Bool(approved)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId, byte[] _data, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "safeTransferFrom", 
                Arrays.<Type>asList(new Address(from),
                new Address(to),
                new Uint256(tokenId),
                new com.cryptape.cita.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<Boolean> isApprovedForAll(String owner, String operator) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("isApprovedForAll", 
                Arrays.<Type>asList(new Address(owner),
                new Address(operator)),
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

    public static RemoteCall<FinanceRepayToken> deploy(CITAj citaj, TransactionManager transactionManager, Long quota, String nonce, Long validUntilBlock, Integer version, String value, BigInteger chainId, BigInteger _shouldRepayTotalAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(_shouldRepayTotalAmount)));
        return deployRemoteCall(FinanceRepayToken.class, citaj, transactionManager, quota, nonce, validUntilBlock, version, chainId, value, BINARY, encodedConstructor);
    }

    public static FinanceRepayToken load(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        return new FinanceRepayToken(contractAddress, citaj, transactionManager);
    }

    public static class DoCreateRepayRecordEventResponse {
        public BigInteger _creditId;

        public BigInteger _repayId;

        public String recordAddress;
    }

    public static class DoConstructorEventResponse {
        public BigInteger _shouldRepayTotalAmount;
    }

    public static class OwnershipRenouncedEventResponse {
        public String previousOwner;
    }

    public static class OwnershipTransferredEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class TransferEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }

    public static class ApprovalEventResponse {
        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse {
        public String owner;

        public String operator;

        public Boolean approved;
    }
}
