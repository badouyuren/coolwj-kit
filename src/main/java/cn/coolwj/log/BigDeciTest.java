package cn.coolwj.log;
/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the god animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author Nigel Lee
 * @date 2022/10/10
 */
public class BigDeciTest {
    public static void main(String[] args) throws IOException {

        JSONArray array = JSONArray.parseArray(json);

        BigDecimal sum = BigDecimal.ZERO;

        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = array.getJSONObject(i);

            String name = obj.getString("name");
            BigDecimal val = obj.getBigDecimal("field14__c");
            System.out.println(name + val);


            sum = sum.add(val);

        }

        System.out.println(sum);

    }


    private static String json = """
            [
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.5,
                    "field30__c": 1655654400000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535400\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.50,\\"field30__c\\":1655654400000,\\"id\\":300059535400,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875526,\\"version\\":11,\\"name\\":\\"红狮水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535400\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028984318,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.68,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "684c7e81-7ccc-4782-8457-34f1df97fc16",
                    "updatedOn": 1665384411490,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411490,
                    "name": "红狮水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411490,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535400",
                    "field13__c": 0.13,
                    "relativeKey": 0,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.68,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.49,
                    "field30__c": 1656172800000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535404\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.49,\\"field30__c\\":1656172800000,\\"id\\":300059535404,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875557,\\"version\\":11,\\"name\\":\\"红狮水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535404\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028984490,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.69,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "10eaf1bd-0896-4629-bb5e-346941f194cc",
                    "updatedOn": 1665384411538,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411538,
                    "name": "红狮水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411538,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535404",
                    "field13__c": 0.13,
                    "relativeKey": 1,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.69,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2957.01,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 340.19,
                    "field30__c": 1656604800000,
                    "field38__c": 340.19,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535408\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2957.01,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":340.19,\\"field30__c\\":1656604800000,\\"id\\":300059535408,\\"field38__c\\":340.19,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875592,\\"version\\":11,\\"name\\":\\"红狮水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535408\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028984589,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":47480.41,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":6.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2616.82,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "e797d34e-34ab-46ea-b279-9949deefaf97",
                    "updatedOn": 1665384411564,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411564,
                    "name": "红狮水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411564,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535408",
                    "field13__c": 0.13,
                    "relativeKey": 2,
                    "field36__c": 47480.41,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 6,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2616.82,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.49,
                    "field30__c": 1656864000000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535412\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.49,\\"field30__c\\":1656864000000,\\"id\\":300059535412,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875626,\\"version\\":11,\\"name\\":\\"红狮水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535412\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028984684,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.69,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "6975837d-63d6-478b-ac2d-c8e1d07758fe",
                    "updatedOn": 1665384411593,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411593,
                    "name": "红狮水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411593,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535412",
                    "field13__c": 0.13,
                    "relativeKey": 3,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.69,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2957.01,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 340.19,
                    "field30__c": 1657987200000,
                    "field38__c": 340.19,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535416\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2957.01,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":340.19,\\"field30__c\\":1657987200000,\\"id\\":300059535416,\\"field38__c\\":340.19,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875657,\\"version\\":11,\\"name\\":\\"红狮水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535416\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028984780,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":47480.41,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":6.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2616.82,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "d1ea4f1b-d103-4f29-af2e-0323908efec7",
                    "updatedOn": 1665384411619,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411619,
                    "name": "红狮水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411619,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535416",
                    "field13__c": 0.13,
                    "relativeKey": 4,
                    "field36__c": 47480.41,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 6,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2616.82,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.49,
                    "field30__c": 1658160000000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535420\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.49,\\"field30__c\\":1658160000000,\\"id\\":300059535420,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875689,\\"version\\":11,\\"name\\":\\"红狮水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535420\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028984876,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.69,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "cf9d7ad3-40d1-47d5-8adc-cf9c9d548f53",
                    "updatedOn": 1665384411644,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411644,
                    "name": "红狮水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411644,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535420",
                    "field13__c": 0.13,
                    "relativeKey": 5,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.69,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.49,
                    "field30__c": 1658419200000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535424\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.49,\\"field30__c\\":1658419200000,\\"id\\":300059535424,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875721,\\"version\\":11,\\"name\\":\\"红狮水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535424\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028984967,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.69,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "b2159a6a-5ce3-4dd6-a877-34670e512dbb",
                    "updatedOn": 1665384411671,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411671,
                    "name": "红狮水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411671,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535424",
                    "field13__c": 0.13,
                    "relativeKey": 6,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.69,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.49,
                    "field30__c": 1658678400000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535428\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.49,\\"field30__c\\":1658678400000,\\"id\\":300059535428,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875753,\\"version\\":11,\\"name\\":\\"红狮水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535428\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028985060,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.69,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "a03cb48f-44d5-4075-913e-6d00020097cf",
                    "updatedOn": 1665384411696,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411696,
                    "name": "红狮水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411696,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535428",
                    "field13__c": 0.13,
                    "relativeKey": 7,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.69,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.49,
                    "field30__c": 1659024000000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535432\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.49,\\"field30__c\\":1659024000000,\\"id\\":300059535432,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875785,\\"version\\":11,\\"name\\":\\"大老虎水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535432\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028985159,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.69,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "ba20ba53-b21f-4075-800b-fa3fe36c4468",
                    "updatedOn": 1665384411723,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411723,
                    "name": "大老虎水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411723,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535432",
                    "field13__c": 0.13,
                    "relativeKey": 8,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.69,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.48,
                    "field30__c": 1659369600000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535436\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.49,\\"field30__c\\":1659369600000,\\"id\\":300059535436,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875818,\\"version\\":11,\\"name\\":\\"大老虎水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535436\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028985254,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.69,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "33c1ef53-cc03-4fb5-be68-106444862d2b",
                    "updatedOn": 1665384411751,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411751,
                    "name": "大老虎水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "field41__c": "材料",
                    "createdOn": 1665384411751,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535436",
                    "field13__c": 0.13,
                    "relativeKey": 9,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 2,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.69,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.49,
                    "field30__c": 1661270400000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535440\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.49,\\"field30__c\\":1661270400000,\\"id\\":300059535440,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875855,\\"version\\":11,\\"name\\":\\"钱江水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535440\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028985348,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.69,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "f3d6b9b3-54ee-450d-a624-11053df85eae",
                    "updatedOn": 1665384411763,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411763,
                    "name": "钱江水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411763,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535440",
                    "field13__c": 0.13,
                    "relativeKey": 10,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.69,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                },
                {
                    "hj": 2464.18,
                    "dj": 492.8358208,
                    "ysmxx":
                    {
                        "code": "300035318242",
                        "metaName": "targetCostDetails13",
                        "name": "水泥"
                    },
                    "field47__c": 0,
                    "field28__c": 0,
                    "metaName": "arrivalDetails13__ss",
                    "field15__c": 283.49,
                    "field30__c": 1661443200000,
                    "field38__c": 283.49,
                    "field19__c":
                    {
                        "code": "300035302609",
                        "metaName": "CustomObject7__c",
                        "name": "义乌玖溪映-202206水泥"
                    },
                    "originalData__ss": "{\\"code\\":\\"300059535444\\",\\"ignoreReadOnly\\":false,\\"isFollowed\\":0,\\"metaData\\":{\\"buildInOrAuxiliary\\":false,\\"childRequired\\":0,\\"id\\":2136744962,\\"name\\":\\"arrivalDetails13\\",\\"objId\\":2136744962},\\"records\\":[{\\"record\\":{\\"hj\\":2464.18,\\"dj\\":492.8358208000,\\"ysmxx\\":{\\"mxbh\\":\\"YSMX-202207-1228\\",\\"hj\\":150000.00,\\"ckj\\":500.0000,\\"code\\":\\"300035318242\\",\\"bizType\\":\\"2133813812\\",\\"dw\\":\\"t\\",\\"ysl\\":300.000,\\"metaName\\":\\"targetCostDetails13\\",\\"name\\":\\"水泥\\",\\"field13__c\\":{\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\"}},\\"field47__c\\":0.00,\\"field28__c\\":0.00,\\"metaName\\":\\"arrivalDetails13\\",\\"field15__c\\":283.49,\\"field30__c\\":1661443200000,\\"id\\":300059535444,\\"field38__c\\":283.49,\\"field19__c\\":{\\"field12__c\\":150000.00,\\"code\\":\\"300035302609\\",\\"bizType\\":\\"300012295623\\",\\"metaName\\":\\"CustomObject7__c\\",\\"name\\":\\"义乌玖溪映-202206水泥\\",\\"field13__c\\":44523.40},\\"updatedBy\\":{\\"code\\":\\"300013666254\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"刘笑平\\"},\\"updatedOn\\":1665294875887,\\"version\\":11,\\"name\\":\\"钱江水泥\\",\\"status\\":0,\\"bizType\\":\\"2136745101\\",\\"code\\":\\"300059535444\\",\\"metaId\\":2136744962,\\"field41__c\\":\\"材料\\",\\"createdOn\\":1663028985439,\\"field26__c\\":1,\\"parent__s\\":{\\"code\\":\\"300059535399\\",\\"bizType\\":\\"2136744294\\",\\"isReadOnly\\":1,\\"metaName\\":\\"materialArrival13\\",\\"name\\":\\"DH-202209-0701\\"},\\"isReadOnly\\":1,\\"field13__c\\":0.1300,\\"field36__c\\":46987.58,\\"owner\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\",\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"}},\\"dhl\\":5.000,\\"dept\\":{\\"path\\":\\"/ZJtiandi88888/300009252098/300013666182\\",\\"code\\":\\"300013666192\\",\\"bizType\\":\\"175941\\",\\"metaName\\":\\"Org\\",\\"name\\":\\"工程二部\\"},\\"entCode\\":\\"ZJtiandi88888\\",\\"createdBy\\":{\\"code\\":\\"300024246757\\",\\"bizType\\":\\"177137\\",\\"metaName\\":\\"User\\",\\"name\\":\\"夏天铖\\"},\\"field39__c\\":{\\"code\\":\\"300017065486\\",\\"bizType\\":\\"300015040992\\",\\"metaName\\":\\"CustomObject152__c\\",\\"name\\":\\"水泥\\"},\\"field14__c\\":2180.69,\\"field18__c\\":{\\"code\\":\\"300028580540\\",\\"bizType\\":\\"2133413725\\",\\"metaName\\":\\"project13\\",\\"name\\":\\"义乌玖溪映项目园林景观工程\\"}},\\"relateds\\":[],\\"treeRelateds\\":[]}]}",
                    "updatedBy": "300010197729",
                    "uniqueKey": "de155c1a-c649-4528-b88b-baabeefb8af5",
                    "updatedOn": 1665384411790,
                    "deleteFlag__ss": 0,
                    "snapshotTime__ss": 1665384411790,
                    "name": "钱江水泥",
                    "status": 0,
                    "bizType": 300053684337,
                    "metaId": 300053684267,
                    "createdOn": 1665384411790,
                    "field26__c": 1,
                    "actionStatus__ss": 2,
                    "followUp":
                    [],
                    "isReadOnly": 0,
                    "originalDataId__ss": "300059535444",
                    "field13__c": 0.13,
                    "relativeKey": 11,
                    "field36__c": 46987.58,
                    "owner": "300010197729",
                    "__actionStatus": 0,
                    "dhl": 5,
                    "dept": "300013666189",
                    "entCode": "ZJtiandi88888",
                    "createdBy": "300010197729",
                    "field39__c":
                    {
                        "code": "300017065486",
                        "metaName": "CustomObject152__c",
                        "name": "水泥"
                    },
                    "snapshotStatus__ss": "0",
                    "field14__c": 2180.69,
                    "field18__c":
                    {
                        "code": "300028580540",
                        "metaName": "project13",
                        "name": "义乌玖溪映项目园林景观工程"
                    }
                }
            ]
            """;

}
