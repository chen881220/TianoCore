/** @file
 CommonDefinition class.

 This class is to define some common marcos and funcions, which used by AutoGen.
 
 Copyright (c) 2006, Intel Corporation
 All rights reserved. This program and the accompanying materials
 are licensed and made available under the terms and conditions of the BSD License
 which accompanies this distribution.  The full text of the license may be found at
 http://opensource.org/licenses/bsd-license.php
 
 THE PROGRAM IS DISTRIBUTED UNDER THE BSD LICENSE ON AN "AS IS" BASIS,
 WITHOUT WARRANTIES OR REPRESENTATIONS OF ANY KIND, EITHER EXPRESS OR IMPLIED.

 **/
package org.tianocore.build.autogen;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
  CommonDefinition
  
  This class is to define some common marcos, which used by AutoGen.
  
**/
public class CommonDefinition {
    public final static String spdSuffix = ".spd";
    public final static String mbdSuffix = ".mbd";
    public final static String msaSuffix = ".msa";
    public final static String LibraryStr = "LIBRARY";
    public final static String autoGenHbegin = "extern int __make_me_compile_correctly;\r\n";
    public final static String include = "#include";
    public final static String autoGenCLine1 = "\r\n";

    public final static String autoGenCLine2 = "const UINT8  _gDebugPropertyMask "
                                               + "= DEBUG_PROPERTY_DEBUG_ASSERT_ENABLED"
                                               + "  | DEBUG_PROPERTY_DEBUG_PRINT_ENABLED"
                                               + "  | DEBUG_PROPERTY_DEBUG_CODE_ENABLED;\r\n";

    public final static String autoGenCLine3 = "const UINTN  _gModuleDefaultErrorLevel"
                                               + " = EFI_D_ERROR | EFI_D_LOAD;\r\n";

    public final static String autoGenHLine1          = "#define EFI_SPECIFICATION_VERSION    0x00020000\r\n";
    public final static String autoGenHVersionDefault = "#define EFI_SPECIFICATION_VERSION    0x00000000\r\n";
    public final static String autoGenHLine2          = "#define EDK_RELEASE_VERSION        0x00090000\r\n";
    public final static String autoGenHReleaseDefault = "#define EDK_RELEASE_VERSION        0x00000000\r\n";

    public final static String includeAutogenH        = "#include    <AutoGen.h>\r\n" ;
    public final static String marcDefineStr          = "#define ";

    public final static String gEfi = "gEfi";
    public final static String protocolGuid = "ProtocolGuid";
    public final static String ppiGuid = "PpiGuid";
    public final static String guidGuid = "Guid";

    public final static String tianoR8FlashMapH = "TianoR8FlashMap.h";
    public final static String flashMapH = "FlashMap.h";

    public final static String pcdLibName = "PcdLib";

    //
    // The defintions for identifying current module
    // is PEI Pcd driver or Dxe Pcd driver.
    // 
    public static enum   PCD_DRIVER_TYPE { NOT_PCD_DRIVER,
        PEI_PCD_DRIVER, 
        DXE_PCD_DRIVER,
        UNKNOWN_PCD_DRIVER};

    //
    // AutoGen.h and AutoGen.c file's header
    //
    public final static String autogenHNotation = 
    "/**\r\n" +
    "  DO NOT EDIT\r\n" +
    "  FILE auto-generated by GenBuild tasks\r\n" +
    "  Module name:\r\n" +
    "       AutoGen.h\r\n" +
    "  Abstract:" +
    "       Auto-generated AutoGen.h for building module or library.\r\n" +
    "**/\r\n\r\n";

    public final static String autogenCNotation = 
    "/**\r\n" +
    "  DO NOT EDIT\r\n" +
    "  FILE auto-generated by GenBuild tasks\r\n" +
    "  Module name:\r\n" +
    "       AutoGen.c\r\n" +
    "  Abstract:" +
    "       Auto-generated AutoGen.c for building module or library.\r\n" +
    "**/\r\n\r\n";

    //
    // module type
    //
    public final static int ModuleTypeBase = 0;
    public final static int ModuleTypeSec = 1;
    public final static int ModuleTypePeiCore = 2;
    public final static int ModuleTypePeim = 3;
    public final static int ModuleTypeDxeCore = 4;
    public final static int ModuleTypeDxeDriver = 5;
    public final static int ModuleTypeDxeRuntimeDriver = 6;
    public final static int ModuleTypeDxeSmmDriver = 7;
    public final static int ModuleTypeDxeSalDriver = 8;
    public final static int ModuleTypeUefiDriver = 9;
    public final static int ModuleTypeUefiApplication = 10;
    public final static int ModuleTypeUnknown = 11;


    //
    // component type
    //                           
    public final static int  ComponentTypeNull = 0;
    public final static int  ComponentTypeApriori = 1;
    public final static int  ComponentTypeSec = 2;
    public final static int  ComponentTypeLibrary = 3;
    public final static int  ComponentTypeFvImageFile = 4;
    public final static int  ComponentTypeBsDriver = 5;
    public final static int  ComponentTypeRtDriver = 6;
    public final static int  ComponentTypeSalRtDriver =7;
    public final static int  ComponentTypePe32Peim = 8;
    public final static int  ComponentTypePicPeim =9;
    public final static int  ComponentTypeCombinedPeimDriver =10;
    public final static int  ComponentTypePeiCore = 11;
    public final static int  ComponentTypeDxeCore = 12;
    public final static int  ComponentTypeApplication = 13;
    public final static int  ComponentTypeBsDriverEfi = 14;
    public final static int  ComponentTypeShellApp = 15;
    public final static int  ComponentTypeBinary =16;
    public final static int  ComponentTypeLogo = 17;
    public final static int  ComponentTypeCustomBuild = 18;
    public final static int  ComponentTypeUnknown = 19;


    //
    // Usaged style
    //
    public final static String AlwaysConsumed = "ALWAYS_CONSUMED";
    public final static String AlwaysProduced = "ALWAYS_PRODUCED";


    public static class MyEnum {
        String moduleTypeStr;
        int   type;

        MyEnum (String str, int type) {
            this.type    = type;
            this.moduleTypeStr = str;
        }

        int ForInt(String str) {
            if (str.equals(this.moduleTypeStr)) {
                return this.type;
            } else
                return -1;
        }
    }

    //
    // Module type
    //
    public static final MyEnum[] moduleEnum = new MyEnum[] {
        new MyEnum("BASE", ModuleTypeBase),
        new MyEnum("SEC", ModuleTypeSec),
        new MyEnum("PEI_CORE", ModuleTypePeiCore),
        new MyEnum("PEIM", ModuleTypePeim),
        new MyEnum("DXE_CORE", ModuleTypeDxeCore),
        new MyEnum("DXE_DRIVER", ModuleTypeDxeDriver),
        new MyEnum("DXE_RUNTIME_DRIVER", ModuleTypeDxeRuntimeDriver),
        new MyEnum("DXE_SAL_DRIVER", ModuleTypeDxeSalDriver),
        new MyEnum("DXE_SMM_DRIVER", ModuleTypeDxeSmmDriver),
        new MyEnum("UEFI_DRIVER", ModuleTypeUefiDriver),
        new MyEnum("UEFI_APPLICATION", ModuleTypeUefiApplication)};

    //
    // Component type
    //
    public static final MyEnum[] componentEnum = new MyEnum[]{
        new MyEnum("APRIORI", ComponentTypeApriori),
        new MyEnum("SEC", ComponentTypeSec),
        new MyEnum("LIBRARY", ComponentTypeLibrary),
        new MyEnum("FV_IMAGE_FILE", ComponentTypeFvImageFile),
        new MyEnum("BS_DRIVER", ComponentTypeBsDriver),
        new MyEnum("RT_DRIVER", ComponentTypeRtDriver),
        new MyEnum("SAL_RT_DRIVER", ComponentTypeSalRtDriver),
        new MyEnum("PE32_PEIM", ComponentTypePe32Peim),
        new MyEnum("PIC_PEIM", ComponentTypePicPeim),
        new MyEnum("COMBINED_PEIM_DRIVER", ComponentTypeCombinedPeimDriver),
        new MyEnum("PEI_CORE", ComponentTypePeiCore),
        new MyEnum("DXE_CORE", ComponentTypeDxeCore),
        new MyEnum("APPLICATION", ComponentTypeApplication),
        new MyEnum("BS_DRIVER_EFI", ComponentTypeBsDriverEfi),
        new MyEnum("SHELLAPP", ComponentTypeShellApp),
        new MyEnum("BINARY", ComponentTypeBinary),
        new MyEnum("LOGO", ComponentTypeLogo),
        new MyEnum("CUSTOM_BUILD", ComponentTypeCustomBuild)
    };

    /**
      getModuleType
      
      This function get the module type value according module type string.
      
      @param  moduleTypeStr     String of modlue type.
      @return                   
    **/
    static public int getModuleType(String moduleTypeStr) {
        int returnValue = -1;
        for (int i = 0; i < CommonDefinition.moduleEnum.length; i++) {
            returnValue = CommonDefinition.moduleEnum[i].ForInt(moduleTypeStr);
            if (returnValue != -1) {
                return returnValue;
            }
        }
        return CommonDefinition.ModuleTypeUnknown;
    }

    /**
      getComponentType
      
      This function get the component type value according commponet type 
      string.
      
      @param    componentTypeStr  String of component type.
      @return
    **/
    static public int getComponentType (String componentTypeStr){
        int returnValue = -1;
        for (int i = 0; i < CommonDefinition.componentEnum.length; i++) {
            returnValue = CommonDefinition.componentEnum[i].ForInt(componentTypeStr);
            if (returnValue != -1) {
                return returnValue;
            }
        }
        return CommonDefinition.ComponentTypeUnknown;
    }

    /**
    getComponentTypeString
    
    This function get the commponet type string according component type value.
    
    @param    componentType  Integer value of component type.
    @return
    **/
    static public String getComponentTypeString (int componentType) {
        if ((componentType > CommonDefinition.ComponentTypeUnknown) || 
            (componentType < CommonDefinition.ComponentTypeNull)) {
            return null;
        }
        for (int index = 0; index < CommonDefinition.componentEnum.length; index ++) {
            if (componentType == CommonDefinition.componentEnum[index].type) {
                return CommonDefinition.componentEnum[index].moduleTypeStr;
            }
        }
        return null;
    }

    /**
      isLibraryComponent 
      
      This function is to check does componet is library according to commponet
      type value.
      
      @param   componentType     Integer value of component type.
      @return
    **/
    static public boolean isLibraryComponent (int componentType) {
        if (ComponentTypeLibrary == componentType) {
            return true;
        }
        return false;
    }

    /**
     * formateGuidName
     * 
     * This function is to formate GUID to ANSI c form.
     * 
     * @param guidNameCon
     *            String of GUID.
     * @return Formated GUID.
     */
    public static String formatGuidName(String guidNameConv) {
        String[] strList;
        String guid = "";
        int index = 0;
        if (guidNameConv
            .matches("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")) {
            strList = guidNameConv.split("-");
            guid = "0x" + strList[0] + ", ";
            guid = guid + "0x" + strList[1] + ", ";
            guid = guid + "0x" + strList[2] + ", ";
            guid = guid + "{";
            guid = guid + "0x" + strList[3].substring(0, 2) + ", ";
            guid = guid + "0x" + strList[3].substring(2, 4);

            while (index < strList[4].length()) {
                guid = guid + ", ";
                guid = guid + "0x" + strList[4].substring(index, index + 2);
                index = index + 2;
            }
            guid = guid + "}";
            return guid;
        } else if (guidNameConv
                   .matches("0x[a-fA-F0-9]{1,8},( )*0x[a-fA-F0-9]{1,4},( )*0x[a-fA-F0-9]{1,4}(,( )*\\{)?(,?( )*0x[a-fA-F0-9]{1,2}){8}( )*(\\})?")) {
            strList = guidNameConv.split(",");

            //
            // chang Microsoft specific form to ANSI c form
            //
            for (int i = 0; i < 3; i++) {
                guid = guid + strList[i] + ",";
            }
            guid = guid + "{";

            for (int i = 3; i < strList.length; i++) {
                if (i == strList.length - 1) {
                    guid = guid + strList[i];
                } else {
                    guid = guid + strList[i] + ",";
                }
            }
            guid = guid + "}";
            return guid;
        } else {
            System.out
            .println("Check GUID Value, It doesn't conform to the registry format specified in the schema!!!");
            return "0";

        }
    }

    /**
     * Remove deuplicat string in list
     * 
     * This function is to duplicat string in list
     * 
     * @param String[]
     *            String list.
     * @return String[] String list which remove the duplicate string.
     */
    public static String[] remDupString (String[] orgList){
        Set<String> strList = new LinkedHashSet<String>();
        String[] desList ;
        if (orgList == null) {
            return new String[0];
        }
        for (int i = 0; i < orgList.length; i++) {
            strList.add(orgList[i]);
        }
        desList = new String[strList.size()];
        Iterator item = strList.iterator();
        int index = 0;
        while (item.hasNext()) {
            desList[index] = (String)item.next();
            index++;
        }
        return desList;
    }

}
