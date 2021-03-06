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
package com.bugvm.apple.uikit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("UIKit")/*</annotations>*/
@Marshaler(/*<name>*/UIApplicationOpenURLOptions/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIApplicationOpenURLOptions/*</name>*/ 
    extends /*<extends>*/NSDictionaryWrapper/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static UIApplicationOpenURLOptions toObject(Class<UIApplicationOpenURLOptions> cls, long handle, long flags) {
            NSDictionary o = (NSDictionary) NSObject.Marshaler.toObject(NSDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new UIApplicationOpenURLOptions(o);
        }
        @MarshalsPointer
        public static long toNative(UIApplicationOpenURLOptions o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.data, flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<UIApplicationOpenURLOptions> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSDictionary> o = (NSArray<NSDictionary>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<UIApplicationOpenURLOptions> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(new UIApplicationOpenURLOptions(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<UIApplicationOpenURLOptions> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSDictionary> array = new NSMutableArray<>();
            for (UIApplicationOpenURLOptions i : l) {
                array.add(i.getDictionary());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constructors>*/
    UIApplicationOpenURLOptions(NSDictionary data) {
        super(data);
    }
    public UIApplicationOpenURLOptions() {}
    /*</constructors>*/

    /*<methods>*/
    public boolean has(NSString key) {
        return data.containsKey(key);
    }
    public NSObject get(NSString key) {
        if (has(key)) {
            return data.get(key);
        }
        return null;
    }
    public UIApplicationOpenURLOptions set(NSString key, NSObject value) {
        data.put(key, value);
        return this;
    }
    

    /**
     * @since Available in iOS 9.0 and later.
     */
    public String getSourceApplication() {
        if (has(Keys.SourceApplication())) {
            NSString val = (NSString) get(Keys.SourceApplication());
            return val.toString();
        }
        return null;
    }
    /**
     * @since Available in iOS 9.0 and later.
     */
    public UIApplicationOpenURLOptions setSourceApplication(String sourceApplication) {
        set(Keys.SourceApplication(), new NSString(sourceApplication));
        return this;
    }
    /**
     * @since Available in iOS 9.0 and later.
     */
    public NSObject getAnnotation() {
        if (has(Keys.Annotation())) {
            NSObject val = (NSObject) get(Keys.Annotation());
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 9.0 and later.
     */
    public UIApplicationOpenURLOptions setAnnotation(NSObject annotation) {
        set(Keys.Annotation(), annotation);
        return this;
    }
    /**
     * @since Available in iOS 9.0 and later.
     */
    public boolean opensInPlace() {
        if (has(Keys.OpenInPlace())) {
            NSNumber val = (NSNumber) get(Keys.OpenInPlace());
            return val.booleanValue();
        }
        return false;
    }
    /**
     * @since Available in iOS 9.0 and later.
     */
    public UIApplicationOpenURLOptions setOpensInPlace(boolean opensInPlace) {
        set(Keys.OpenInPlace(), NSNumber.valueOf(opensInPlace));
        return this;
    }
    /*</methods>*/
    
    /*<keys>*/
    @Library("UIKit")
    public static class Keys {
        static { Bro.bind(Keys.class); }
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="UIApplicationOpenURLOptionsSourceApplicationKey", optional=true)
        public static native NSString SourceApplication();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="UIApplicationOpenURLOptionsAnnotationKey", optional=true)
        public static native NSString Annotation();
        /**
         * @since Available in iOS 9.0 and later.
         */
        @GlobalValue(symbol="UIApplicationOpenURLOptionsOpenInPlaceKey", optional=true)
        public static native NSString OpenInPlace();
    }
    /*</keys>*/
}
