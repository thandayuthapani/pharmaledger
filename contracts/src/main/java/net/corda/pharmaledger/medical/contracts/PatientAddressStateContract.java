package net.corda.pharmaledger.medical.contracts;

import static net.corda.core.contracts.ContractsDSL.requireThat;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.contracts.ContractState;
import net.corda.core.transactions.LedgerTransaction;
import net.corda.pharmaledger.medical.states.PatientAddressState;

public class PatientAddressStateContract implements Contract {
    public static final String ID = "net.corda.pharmaledger.medical.contracts.PatientAddressStateContract";

    @Override
    public void verify(LedgerTransaction tx) throws IllegalArgumentException {
        List<ContractState> outputs = tx.getOutputStates();
		requireThat(require -> {
			PatientAddressState patientAddress = (PatientAddressState) outputs.get(0);
			require.using("Address should not be empty", !StringUtils.isEmpty(patientAddress.getPatientAddress()));
			require.using("Shipment Mapping ID should not be empty", !StringUtils.isEmpty(patientAddress.getShipmentMappingID()));
			require.using("Email ID should not be empty", !StringUtils.isEmpty(patientAddress.getPatientMailID()));
			return null;
		});
    }

    public interface Commands extends CommandData {
        class Create implements Commands {}
    }
    
}
