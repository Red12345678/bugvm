/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bugvm.apple.storekit;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("StoreKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKPaymentTransaction/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKPaymentTransactionPtr extends Ptr<SKPaymentTransaction, SKPaymentTransactionPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKPaymentTransaction.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKPaymentTransaction() {}
    protected SKPaymentTransaction(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "error")
    public native NSError getError();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "originalTransaction")
    public native SKPaymentTransaction getOriginalTransaction();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "payment")
    public native SKPayment getPayment();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "downloads")
    public native NSArray<SKDownload> getDownloads();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "transactionDate")
    public native NSDate getTransactionDate();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "transactionIdentifier")
    public native String getTransactionIdentifier();
    /**
     * @since Available in iOS 3.0 and later.
     * @deprecated Deprecated in iOS 7.0.
     */
    @Deprecated
    @Property(selector = "transactionReceipt")
    public native NSData getTransactionReceipt();
    /**
     * @since Available in iOS 3.0 and later.
     */
    @Property(selector = "transactionState")
    public native SKPaymentTransactionState getTransactionState();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
