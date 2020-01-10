package com.ipaynow.bcfinance.chain.contract;

import com.cryptape.cita.abi.*;
import com.cryptape.cita.abi.datatypes.Address;
import com.cryptape.cita.abi.datatypes.DynamicArray;
import com.cryptape.cita.abi.datatypes.Event;
import com.cryptape.cita.abi.datatypes.Type;
import com.cryptape.cita.abi.datatypes.generated.Uint256;
import com.cryptape.cita.abi.datatypes.generated.Uint32;
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
public class AssetStatementFactory extends Contract {
    private static final String BINARY = "6080604052600160025534801561001557600080fd5b50604051602080612c598339810180604052602081101561003557600080fd5b810190808051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146100fd5780600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5050612b4b8061010e6000396000f3fe60806040523480156200001157600080fd5b5060043610620000a05760003560e01c80638da5cb5b116200006f5780638da5cb5b146200023e578063aa03fa3d146200028a578063ac0cc86814620002fb578063dd4752e2146200031b578063f2fde38b14620005e657620000a0565b806357dfb1cd14620000a55780636b4e2ff814620000d6578063715018a614620001eb578063747293fb14620001f7575b600080fd5b620000d460048036036020811015620000bd57600080fd5b81019080803590602001909291905050506200062d565b005b6200019260048036036020811015620000ee57600080fd5b81019080803590602001906401000000008111156200010c57600080fd5b8201836020820111156200011f57600080fd5b803590602001918460208302840111640100000000831117156200014257600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600081840152601f19601f820116905080830192505050505050509192919290505050620006d9565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015620001d7578082015181840152602081019050620001ba565b505050509050019250505060405180910390f35b620001f5620007e5565b005b6200023c600480360360208110156200020f57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050620008e6565b005b6200024862000a52565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b620002b960048036036020811015620002a257600080fd5b810190808035906020019092919050505062000a77565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6200030562000ab4565b6040518082815260200191505060405180910390f35b620005e460048036036101208110156200033457600080fd5b81019080803563ffffffff169060200190929190803560030b9060200190929190803590602001906401000000008111156200036f57600080fd5b8201836020820111156200038257600080fd5b80359060200191846001830284011164010000000083111715620003a557600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001909291908035906020019092919080359060200190929190803590602001906401000000008111156200042757600080fd5b8201836020820111156200043a57600080fd5b803590602001918460018302840111640100000000831117156200045d57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080359060200190640100000000811115620004c157600080fd5b820183602082011115620004d457600080fd5b80359060200191846001830284011164010000000083111715620004f757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156200055b57600080fd5b8201836020820111156200056e57600080fd5b803590602001918460018302840111640100000000831117156200059157600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929050505062000aba565b005b6200062b60048036036020811015620005fe57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505062000f25565b005b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff16146200068857600080fd5b806002819055503373ffffffffffffffffffffffffffffffffffffffff16816002547f06d0981ddf88b524abcd78795702af5c17e6616ceb8eb4aa2b47db576d7a912060405160405180910390a450565b60608082516040519080825280602002602001820160405280156200070d5781602001602082028038833980820191505090505b50905060008090505b83518163ffffffff161015620007db5760046000858363ffffffff16815181106200073d57fe5b602002602001015163ffffffff1663ffffffff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828263ffffffff16815181106200079357fe5b602002602001019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050808060010191505062000716565b5080915050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146200083f57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482060405160405180910390a260008060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b620008f062000f8d565b806200094857506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b6200095257600080fd5b60018190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f1f093a78a21a82ed6238de789572498070341906fef2e34101e9b99d3b10f0633382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a150565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6001818154811062000a8557fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b600073ffffffffffffffffffffffffffffffffffffffff16600460008b63ffffffff1663ffffffff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161462000bd557600460008a63ffffffff1663ffffffff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167fe7bfdbc101bcab173c22ffb0c96657cbf721c0a2b94526a25b7e5fc124f25a2d8a42604051808363ffffffff1663ffffffff1681526020018281526020019250505060405180910390a262000f1a565b6000898989898989898989600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660405162000c11906200112e565b808b63ffffffff1663ffffffff1681526020018a60030b60030b8152602001806020018981526020018881526020018781526020018060200180602001806020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200185810385528d818151815260200191508051906020019080838360005b8381101562000cbe57808201518184015260208101905062000ca1565b50505050905090810190601f16801562000cec5780820380516001836020036101000a031916815260200191505b50858103845289818151815260200191508051906020019080838360005b8381101562000d2757808201518184015260208101905062000d0a565b50505050905090810190601f16801562000d555780820380516001836020036101000a031916815260200191505b50858103835288818151815260200191508051906020019080838360005b8381101562000d9057808201518184015260208101905062000d73565b50505050905090810190601f16801562000dbe5780820380516001836020036101000a031916815260200191505b50858103825287818151815260200191508051906020019080838360005b8381101562000df957808201518184015260208101905062000ddc565b50505050905090810190601f16801562000e275780820380516001836020036101000a031916815260200191505b509e505050505050505050505050505050604051809103906000f08015801562000e55573d6000803e3d6000fd5b50905080600460008c63ffffffff1663ffffffff16815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508073ffffffffffffffffffffffffffffffffffffffff167fe7bfdbc101bcab173c22ffb0c96657cbf721c0a2b94526a25b7e5fc124f25a2d8b42604051808363ffffffff1663ffffffff1681526020018281526020019250505060405180910390a2505b505050505050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161462000f7f57600080fd5b62000f8a8162001035565b50565b6000806000905060008090505b6001805490508110156200102d573373ffffffffffffffffffffffffffffffffffffffff166001828154811062000fcd57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156200101f57600191506200102d565b808060010191505062000f9a565b508091505090565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156200107057600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6119e3806200113d8339019056fe608060405260016002553480156200001657600080fd5b50604051620019e3380380620019e383398101806040526101408110156200003d57600080fd5b81019080805190602001909291908051906020019092919080516401000000008111156200006a57600080fd5b828101905060208101848111156200008157600080fd5b81518560018202830111640100000000821117156200009f57600080fd5b50509291906020018051906020019092919080519060200190929190805190602001909291908051640100000000811115620000da57600080fd5b82810190506020810184811115620000f157600080fd5b81518560018202830111640100000000821117156200010f57600080fd5b505092919060200180516401000000008111156200012c57600080fd5b828101905060208101848111156200014357600080fd5b81518560018202830111640100000000821117156200016157600080fd5b505092919060200180516401000000008111156200017e57600080fd5b828101905060208101848111156200019557600080fd5b8151856001820283011164010000000082111715620001b357600080fd5b50509291906020018051906020019092919050505080336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614620002805780600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50326000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555033600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060013390806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505089600460146101000a81548163ffffffff021916908363ffffffff16021790555088600460186101000a81548163ffffffff021916908360030b63ffffffff1602179055508760059080519060200190620003c59291906200056a565b508660068190555085600781905550846008819055508360099080519060200190620003f39291906200056a565b5082600a90805190602001906200040c9291906200056a565b5081600b9080519060200190620004259291906200056a565b507f07b46976200edd250711b207a94682a7bc583a350114307786a848ac0130a243600460149054906101000a900463ffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684604051808563ffffffff1663ffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200194505050505060405180910390a15050505050505050505062000619565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620005ad57805160ff1916838001178555620005de565b82800160010185558215620005de579182015b82811115620005dd578251825591602001919060010190620005c0565b5b509050620005ed9190620005f1565b5090565b6200061691905b8082111562000612576000816000905550600101620005f8565b5090565b90565b6113ba80620006296000396000f3fe608060405234801561001057600080fd5b50600436106101215760003560e01c8063747293fb116100ad578063ac0cc86811610071578063ac0cc8681461074a578063af640d0f14610768578063ba0b184114610792578063ed6aaa0e146107b0578063f2fde38b146107ce57610121565b8063747293fb146105485780637b1a33141461058c5780637c2ffbb31461060f5780638da5cb5b14610692578063aa03fa3d146106dc57610121565b80635a540f2c116100f45780635a540f2c1461027d5780635e3109e71461029b5780635f86e2b0146104975780636418dca81461051a578063715018a61461053e57610121565b806302d05d3f146101265780630730ca19146101705780631d655c59146101f357806357dfb1cd1461024f575b600080fd5b61012e610812565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610178610838565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101b857808201518184015260208101905061019d565b50505050905090810190601f1680156101e55780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6102356004803603602081101561020957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506108d6565b604051808215151515815260200191505060405180910390f35b61027b6004803603602081101561026557600080fd5b810190808035906020019092919050505061092f565b005b6102856109da565b6040518082815260200191505060405180910390f35b6102a36109e0565b604051808a63ffffffff1663ffffffff1681526020018960030b60030b81526020018060200188815260200187815260200186815260200180602001806020018060200185810385528c818151815260200191508051906020019080838360005b8381101561031f578082015181840152602081019050610304565b50505050905090810190601f16801561034c5780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360005b8381101561038557808201518184015260208101905061036a565b50505050905090810190601f1680156103b25780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019080838360005b838110156103eb5780820151818401526020810190506103d0565b50505050905090810190601f1680156104185780820380516001836020036101000a031916815260200191505b50858103825286818151815260200191508051906020019080838360005b83811015610451578082015181840152602081019050610436565b50505050905090810190601f16801561047e5780820380516001836020036101000a031916815260200191505b509d505050505050505050505050505060405180910390f35b61049f610cb0565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156104df5780820151818401526020810190506104c4565b50505050905090810190601f16801561050c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610522610d4e565b604051808260030b60030b815260200191505060405180910390f35b610546610d61565b005b61058a6004803603602081101561055e57600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610e61565b005b610594610fc9565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156105d45780820151818401526020810190506105b9565b50505050905090810190601f1680156106015780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610617611067565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561065757808201518184015260208101905061063c565b50505050905090810190601f1680156106845780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61069a611105565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610708600480360360208110156106f257600080fd5b810190808035906020019092919050505061112a565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610752611166565b6040518082815260200191505060405180910390f35b61077061116c565b604051808263ffffffff1663ffffffff16815260200191505060405180910390f35b61079a611182565b6040518082815260200191505060405180910390f35b6107b8611188565b6040518082815260200191505060405180910390f35b610810600480360360208110156107e457600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061118e565b005b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600b8054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108ce5780601f106108a3576101008083540402835291602001916108ce565b820191906000526020600020905b8154815290600101906020018083116108b157829003601f168201915b505050505081565b60008173ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16149050919050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff161461098957600080fd5b806002819055503373ffffffffffffffffffffffffffffffffffffffff16816002547f06d0981ddf88b524abcd78795702af5c17e6616ceb8eb4aa2b47db576d7a912060405160405180910390a450565b60065481565b600080606060008060006060806060600460149054906101000a900463ffffffff16600460189054906101000a900460030b60056006546007546008546009600a600b868054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ab85780601f10610a8d57610100808354040283529160200191610ab8565b820191906000526020600020905b815481529060010190602001808311610a9b57829003601f168201915b50505050509650828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610b545780601f10610b2957610100808354040283529160200191610b54565b820191906000526020600020905b815481529060010190602001808311610b3757829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bf05780601f10610bc557610100808354040283529160200191610bf0565b820191906000526020600020905b815481529060010190602001808311610bd357829003601f168201915b50505050509150808054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c8c5780601f10610c6157610100808354040283529160200191610c8c565b820191906000526020600020905b815481529060010190602001808311610c6f57829003601f168201915b50505050509050985098509850985098509850985098509850909192939495969798565b60058054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d465780601f10610d1b57610100808354040283529160200191610d46565b820191906000526020600020905b815481529060010190602001808311610d2957829003601f168201915b505050505081565b600460189054906101000a900460030b81565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610dba57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167ff8df31144d9c2f0f6b59d69b8b98abd5459d07f2742c4df920b25aae33c6482060405160405180910390a260008060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550565b610e696111f3565b80610ec057506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b610ec957600080fd5b60018190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550507f1f093a78a21a82ed6238de789572498070341906fef2e34101e9b99d3b10f0633382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019250505060405180910390a150565b60098054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561105f5780601f106110345761010080835404028352916020019161105f565b820191906000526020600020905b81548152906001019060200180831161104257829003601f168201915b505050505081565b600a8054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110fd5780601f106110d2576101008083540402835291602001916110fd565b820191906000526020600020905b8154815290600101906020018083116110e057829003601f168201915b505050505081565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6001818154811061113757fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b600460149054906101000a900463ffffffff1681565b60075481565b60085481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16146111e757600080fd5b6111f081611296565b50565b6000806000905060008090505b60018054905081101561128e573373ffffffffffffffffffffffffffffffffffffffff166001828154811061123157fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611281576001915061128e565b8080600101915050611200565b508091505090565b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156112d057600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505056fea165627a7a723058203bbcab6f8ac03861fcee3f78783dbde1af88bc0901b8b6c986eb440a7790c2b90029a165627a7a723058203f3fcb4329bc645c7f9c35d9de0902f07f767724ac4c55e34c2f4644377ed6ab0029";

    protected AssetStatementFactory(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        super(BINARY, contractAddress, citaj, transactionManager);
    }

    public List<DoCreateAssetStatementEventResponse> getDoCreateAssetStatementEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("doCreateAssetStatement", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DoCreateAssetStatementEventResponse> responses = new ArrayList<DoCreateAssetStatementEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DoCreateAssetStatementEventResponse typedResponse = new DoCreateAssetStatementEventResponse();
            typedResponse.assetStatementAddr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.openTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DoCreateAssetStatementEventResponse> doCreateAssetStatementEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("doCreateAssetStatement", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}, new TypeReference<Uint256>() {}));
        AppFilter filter = new AppFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return citaj.appLogFlowable(filter).map(new Function<Log, DoCreateAssetStatementEventResponse>() {
            @Override
            public DoCreateAssetStatementEventResponse apply(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DoCreateAssetStatementEventResponse typedResponse = new DoCreateAssetStatementEventResponse();
                typedResponse.assetStatementAddr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
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

    public RemoteCall<TransactionReceipt> changeLifecycle(BigInteger _lifecycle, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "changeLifecycle", 
                Arrays.<Type>asList(new Uint256(_lifecycle)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, quota, nonce, validUntilBlock, version, chainId, value);
    }

    public RemoteCall<List> queryAssetStatement(List<BigInteger> _ids) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function("queryAssetStatement", 
                Arrays.<Type>asList(new DynamicArray<Uint32>(
                        Utils.typeMap(_ids, Uint32.class))),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return executeRemoteCallSingleValueReturn(function, List.class);
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

    public RemoteCall<TransactionReceipt> createAssetStatement(BigInteger _id, BigInteger _merchantNo, String _plantName, BigInteger _stockAmount, BigInteger _soldForSettlementAmount, BigInteger _settledForPaymentAmount, String _stockTurnOverRatio, String _returnRate, String _statisticalDate, Long quota, String nonce, Long validUntilBlock, Integer version, BigInteger chainId, String value) {
        com.cryptape.cita.abi.datatypes.Function function = new com.cryptape.cita.abi.datatypes.Function(
                "createAssetStatement", 
                Arrays.<Type>asList(new Uint32(_id),
                new com.cryptape.cita.abi.datatypes.generated.Int32(_merchantNo), 
                new com.cryptape.cita.abi.datatypes.Utf8String(_plantName), 
                new com.cryptape.cita.abi.datatypes.generated.Int256(_stockAmount), 
                new com.cryptape.cita.abi.datatypes.generated.Int256(_soldForSettlementAmount), 
                new com.cryptape.cita.abi.datatypes.generated.Int256(_settledForPaymentAmount), 
                new com.cryptape.cita.abi.datatypes.Utf8String(_stockTurnOverRatio), 
                new com.cryptape.cita.abi.datatypes.Utf8String(_returnRate), 
                new com.cryptape.cita.abi.datatypes.Utf8String(_statisticalDate)), 
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

    public static RemoteCall<AssetStatementFactory> deploy(CITAj citaj, TransactionManager transactionManager, Long quota, String nonce, Long validUntilBlock, Integer version, String value, BigInteger chainId, String _superAdmin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_superAdmin)));
        return deployRemoteCall(AssetStatementFactory.class, citaj, transactionManager, quota, nonce, validUntilBlock, version, chainId, value, BINARY, encodedConstructor);
    }

    public static AssetStatementFactory load(String contractAddress, CITAj citaj, TransactionManager transactionManager) {
        return new AssetStatementFactory(contractAddress, citaj, transactionManager);
    }

    public static class DoCreateAssetStatementEventResponse {
        public String assetStatementAddr;

        public BigInteger id;

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
