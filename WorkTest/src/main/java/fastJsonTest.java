import com.alibaba.fastjson.JSONObject;

public class fastJsonTest {
    class AddressDto{
        private String address;
        private String chainPath;
        private String alias;
        private String gasPrice;

        public void setAddress(String address) {
            this.address = address;
        }

        public void setChainPath(String chainPath) {
            this.chainPath = chainPath;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setGasPrice(String gasPrice) {
            this.gasPrice = gasPrice;
        }
    }
    public static void main(String[] args) {
//        AddressDto addressDto = new AddressDto();
//        addressDto.setAddress("111");
//        addressDto.setChainPath("3333");
//        addressDto.setAlias("6666");
//        addressDto.setGasPrice(777.0);
//        JSONObject jsonObject = JSONObject.parseObject(addressDto.toString());
        //        return JSONObject.parseObject(JSON.toJSONString(addreInfo.getData()));
    }


}
