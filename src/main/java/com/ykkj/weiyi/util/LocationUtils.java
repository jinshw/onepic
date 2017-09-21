package com.ykkj.weiyi.util;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
public class LocationUtils {
    private static double RadPerDeg64 = Math.PI * 2 / 360;

    /**
     * 求两个坐标点距离
     *
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static double getDistanceVincenty(double lon1, double lat1,
                                             double lon2, double lat2)//根据经纬度求取椭圆距离
    {
        double a = 6378137, b = 6356752.314245, f = 1 / 298.257223563; // WGS-84
        // ellipsoid
        // params
        double L = RadPerDeg64 * (lon2 - lon1);

        double U1 = Math.atan((1 - f) * Math.tan(RadPerDeg64 * (lat1)));
        double U2 = Math.atan((1 - f) * Math.tan(RadPerDeg64 * (lat2)));
        double sinU1 = Math.sin(U1), cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2), cosU2 = Math.cos(U2);

        double lambda = L, lambdaP;
        int iterLimit = 100;
        double cosSqAlpha;
        double sinSigma;
        double cos2SigmaM;
        double cosSigma;
        double sigma;
        double sinLambda, cosLambda;
        do {
            sinLambda = Math.sin(lambda);
            cosLambda = Math.cos(lambda);
            sinSigma = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda)
                    + (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda)
                    * (cosU1 * sinU2 - sinU1 * cosU2 * cosLambda));
            if (sinSigma == 0)
                return 0; // co-incident points
            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma = Math.atan2(sinSigma, cosSigma);
            double sinAlpha = cosU1 * cosU2 * sinLambda / sinSigma;
            cosSqAlpha = 1 - sinAlpha * sinAlpha;
            cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cosSqAlpha;
            // if (_isnan(cos2SigmaM))
            // cos2SigmaM = 0; // equatorial line: cosSqAlpha=0 (§6)
            double C = f / 16 * cosSqAlpha * (4 + f * (4 - 3 * cosSqAlpha));
            lambdaP = lambda;
            lambda = L
                    + (1 - C)
                    * f
                    * sinAlpha
                    * (sigma + C
                    * sinSigma
                    * (cos2SigmaM + C * cosSigma
                    * (-1 + 2 * cos2SigmaM * cos2SigmaM)));
        } while ((lambda - lambdaP > 1e-12 || lambdaP - lambda > 1e-12)
                && --iterLimit > 0);

        if (iterLimit == 0)
            return -1; // formula failed to converge

        double uSq = cosSqAlpha * (a * a - b * b) / (b * b);
        double A = 1 + uSq / 16384
                * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
        double deltaSigma = B
                * sinSigma
                * (cos2SigmaM + B
                / 4
                * (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) - B
                / 6 * cos2SigmaM
                * (-3 + 4 * sinSigma * sinSigma)
                * (-3 + 4 * cos2SigmaM * cos2SigmaM)));
        double s = b * A * (sigma - deltaSigma);

        return s;
    }

    public static void main(String[] args) {
        double dd2 = LocationUtils.getDistanceVincenty(Double.valueOf("90.914306640938889"),
                Double.valueOf("43.746520995947378"),
                Double.valueOf("90.893676757976152"),
                Double.valueOf("43.751525878716507"));
        double qq2 = LocationUtils.getQM(Double.valueOf("90.914306640938889"),
                Double.valueOf("43.746520995947378"),
                Double.valueOf("90.893676757976152"),
                Double.valueOf("43.751525878716507"));
        System.out.println(dd2 + "====" + qq2);
    }

    /**
     * 假设地球是个完美球体
     *
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static double getQM(double lon1, double lat1, double lon2, double lat2) {

        double a = 6378137, b = 6356752.314245, f = 1 / 298.257223563; // WGS-84
        double R = b / 1000;
        //L8 =π·q(1 + 3h/(10 + √(4-3h)))·(1 +mn)
        //(q=a+b，h=((a-b)/(a+b))^2，m=22/7π-1，n=((a-b)/a)^33.697)
        double q = a + b;
        double h = Math.pow((a - b) / (a + b), 2);
        double m = 22 / (7 * Math.PI) - 1;
        double n = Math.pow(((a - b) / a), 33.697);

//        double L8 = π·q(1 + 3h / (10 + √ (4 - 3 h)))·(1 + mn);
//       double L8 = Math.PI * q * (1 + 3* h / (10 + Math.sqrt((4 - 3*h)))*(1 + m * n));
        //L6= π√[2(a^2+b^2)] (较近似)
        double L8 = Math.PI * Math.sqrt(2 * (Math.pow(a, 2) + Math.pow(b, 2)));
        return L8;
    }
}
