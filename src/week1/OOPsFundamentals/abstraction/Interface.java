package week1.OOPsFundamentals.abstraction;

//gives info regarding interface, multiple inheritance, default methods and their collision in the first concrete class

interface AppleInterface{
    final String DEVICE_ID ="macAddress";

    default String getDeviceId(AppleInterface obj){
         return obj.DEVICE_ID;
    }




}

interface AndroidInterface{
    final String DEVICE_ID ="macAddress";

    default String getDeviceId(AndroidInterface obj){
        return obj.DEVICE_ID;
    }


}

interface WebInterface{

    final String DEVICE_ID ="macAddress";

    default String getDeviceId(WebInterface obj){
        return obj.DEVICE_ID;
    }

}

class OurJavaApp implements AppleInterface,AndroidInterface,WebInterface{

    String deviceType;

    public OurJavaApp(String deviceType) {
        this.deviceType = deviceType;
    }



    //    @Override
//    public String getDeviceId(OurJavaApp object) {
//
//        switch (object.deviceType){
//
//            case "Android" :
//                 return AndroidInterface.super.getDeviceId();
//                 break;
//            case "Apple" :
//                return  AppleInterface.super.getDeviceId();
//                break;
//            case "Web" :
//                return  WebInterface.super.getDeviceId();
//                break;
//
//        }
//
//
//        return null;
//    }
}




public class Interface {


}
