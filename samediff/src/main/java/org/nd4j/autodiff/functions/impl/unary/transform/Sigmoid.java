package org.nd4j.autodiff.functions.impl.unary.transform;

import org.nd4j.autodiff.ArrayField;
import org.nd4j.autodiff.functions.AbstractUnaryFunction;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;

public class Sigmoid extends AbstractUnaryFunction<ArrayField> {
    public Sigmoid(SameDiff sameDiff, DifferentialFunction<ArrayField> i_v, Object[] extraArgs) {
        super(sameDiff, i_v, extraArgs);
    }

    @Override
    public ArrayField doGetValue() {
        return sameDiff.getArrayFactory().sigmoid(arg().getValue(true));
    }



    @Override
    public DifferentialFunction<ArrayField> diff(DifferentialFunction<ArrayField> i_v) {
        return sameDiff.getFunctionFactory().sigmoidDerivative(arg(), i_v);
    }

    @Override
    public String functionName() {
        return new org.nd4j.linalg.api.ops.impl.transforms.Sigmoid().name();
    }
}
