package com.atm.actions;

import com.atm.dto.BillsDTO;
import com.atm.entities.Atm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AtmOperations {

    protected static final int[] billTypes = {500, 200, 100, 50, 10, 5, 1};
    protected static int[] billValues = new int[7];

    public AtmOperations() {
    }

    public BillsDTO withdrawAlgorithm(Integer withdrawSum, Iterable<Atm> atm) {
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < billValues.length; i++) {
            billValues[i] = atm.iterator().next().getCount();
            int howManyBillsOfTypeN = withdrawSum / billTypes[i];
            if (howManyBillsOfTypeN > 0) {
                if (howManyBillsOfTypeN < billValues[i]) {
                    withdrawSum = withdrawSum - billTypes[i] * howManyBillsOfTypeN;
                    returnList.add(i, howManyBillsOfTypeN);
                } else {
                    withdrawSum = withdrawSum - billTypes[i] * billValues[i];
                    returnList.add(i, billValues[i]);
                }
            } else {
                returnList.add(i, howManyBillsOfTypeN);
            }
        }
        if (withdrawSum != 0) {
            return null;
        }
        return getListAsDTO(returnList);
    }

    public List<Integer> getDTOasList(BillsDTO billsDTO) {
        List<Integer> list = new ArrayList<>();
        for (Method method : billsDTO.getClass().getMethods()) {
            if (method.getName().startsWith("get_")) {
                try {
                    if (method.invoke(billsDTO) instanceof Integer)
                        list.add((Integer) method.invoke(billsDTO));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public BillsDTO getListAsDTO(List<Integer> list) {
        BillsDTO billsDTO = new BillsDTO();
        int index = list.size() - 1;
        for (Method method : billsDTO.getClass().getMethods()) {
            if (method.getName().startsWith("set_")) {
                try {
                    method.invoke(billsDTO, list.get(index));
                    index--;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return billsDTO;
    }

    public boolean validate(Iterable<Atm> atm) {
        for (Atm valid : atm) {
            if (valid.getCount() > 100000) {
                return false;
            }
        }
        return true;
    }
}
