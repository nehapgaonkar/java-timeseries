package data;

import stats.Statistics;

public final class DoubleFunctions {

  private DoubleFunctions() {}
  
  public static final double[] newArray(double... data) {
    return data;
  }

  public static final double[] fill(final int size, final double value) {
    final double[] filled = new double[size];
    for (int i = 0; i < filled.length; i++) {
      filled[i] = value;
    }
    return filled;
  }

  public static final double[] slice(final double[] data, final int from, final int to) {
    final double[] sliced = new double[to - from];
    System.arraycopy(data, from, sliced, 0, to - from);
    return sliced;
  }

  public static final double[] boxCox(final double[] data, final double lambda) {
    final double[] boxCoxed = new double[data.length];
    if (Math.abs(lambda) < 1E-15) { 
      for (int i = 0; i < boxCoxed.length; i++) {
        boxCoxed[i] = Math.log(data[i]);
      }
      
    } else {
      for (int i = 0; i < boxCoxed.length; i++) {
        boxCoxed[i] = (Math.pow(data[i], lambda) - 1) / lambda;
      }
    }
    return boxCoxed;
  }

  public static final double[] inverseBoxCox(final double[] data, final double lambda) {
    final double[] invBoxCoxed = new double[data.length];
    if (Math.abs(lambda) < 1E-15) {
      for (int i = 0; i < invBoxCoxed.length; i++) {
        invBoxCoxed[i] = Math.exp(data[i]);
      }
    } else {
      for (int i = 0; i < invBoxCoxed.length; i++) {
        invBoxCoxed[i] = Math.pow(data[i] * lambda + 1, 1 / lambda);
      }
    }
    return invBoxCoxed;
  }
  
  public static final double[] demean(final double[] data) {
    final double mean = Statistics.meanOf(data);
    final double[] demeaned = new double[data.length];
    for (int t = 0; t < data.length; t++) {
      demeaned[t] = data[t] - mean;
    }
    return demeaned;
  }
}