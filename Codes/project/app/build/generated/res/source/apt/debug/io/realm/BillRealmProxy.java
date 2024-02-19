package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class BillRealmProxy extends com.fitzafful.gliveportal.db.Bill
    implements RealmObjectProxy, BillRealmProxyInterface {

    static final class BillColumnInfo extends ColumnInfo {
        long idIndex;
        long bill_nameIndex;
        long amountIndex;
        long creditIndex;
        long termIndex;
        long yearIndex;
        long typeIndex;
        long createdDateIndex;

        BillColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Bill");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.bill_nameIndex = addColumnDetails("bill_name", objectSchemaInfo);
            this.amountIndex = addColumnDetails("amount", objectSchemaInfo);
            this.creditIndex = addColumnDetails("credit", objectSchemaInfo);
            this.termIndex = addColumnDetails("term", objectSchemaInfo);
            this.yearIndex = addColumnDetails("year", objectSchemaInfo);
            this.typeIndex = addColumnDetails("type", objectSchemaInfo);
            this.createdDateIndex = addColumnDetails("createdDate", objectSchemaInfo);
        }

        BillColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BillColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BillColumnInfo src = (BillColumnInfo) rawSrc;
            final BillColumnInfo dst = (BillColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.bill_nameIndex = src.bill_nameIndex;
            dst.amountIndex = src.amountIndex;
            dst.creditIndex = src.creditIndex;
            dst.termIndex = src.termIndex;
            dst.yearIndex = src.yearIndex;
            dst.typeIndex = src.typeIndex;
            dst.createdDateIndex = src.createdDateIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(8);
        fieldNames.add("id");
        fieldNames.add("bill_name");
        fieldNames.add("amount");
        fieldNames.add("credit");
        fieldNames.add("term");
        fieldNames.add("year");
        fieldNames.add("type");
        fieldNames.add("createdDate");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private BillColumnInfo columnInfo;
    private ProxyState<com.fitzafful.gliveportal.db.Bill> proxyState;

    BillRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BillColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.fitzafful.gliveportal.db.Bill>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.idIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$bill_name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.bill_nameIndex);
    }

    @Override
    public void realmSet$bill_name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.bill_nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.bill_nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.bill_nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.bill_nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$amount() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.amountIndex);
    }

    @Override
    public void realmSet$amount(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.amountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.amountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.amountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.amountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$credit() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.creditIndex);
    }

    @Override
    public void realmSet$credit(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.creditIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.creditIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.creditIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.creditIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$term() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.termIndex);
    }

    @Override
    public void realmSet$term(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.termIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.termIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.termIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.termIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$year() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.yearIndex);
    }

    @Override
    public void realmSet$year(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.yearIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.yearIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.yearIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.yearIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$createdDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.createdDateIndex);
    }

    @Override
    public void realmSet$createdDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.createdDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.createdDateIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Bill", 8, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("bill_name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("amount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("credit", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("term", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("year", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("createdDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static BillColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new BillColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Bill";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.fitzafful.gliveportal.db.Bill createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.fitzafful.gliveportal.db.Bill obj = null;
        if (update) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Bill.class);
            BillColumnInfo columnInfo = (BillColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Bill.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Bill.class), false, Collections.<String> emptyList());
                    obj = new io.realm.BillRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.BillRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Bill.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.BillRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Bill.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final BillRealmProxyInterface objProxy = (BillRealmProxyInterface) obj;
        if (json.has("bill_name")) {
            if (json.isNull("bill_name")) {
                objProxy.realmSet$bill_name(null);
            } else {
                objProxy.realmSet$bill_name((String) json.getString("bill_name"));
            }
        }
        if (json.has("amount")) {
            if (json.isNull("amount")) {
                objProxy.realmSet$amount(null);
            } else {
                objProxy.realmSet$amount((String) json.getString("amount"));
            }
        }
        if (json.has("credit")) {
            if (json.isNull("credit")) {
                objProxy.realmSet$credit(null);
            } else {
                objProxy.realmSet$credit((String) json.getString("credit"));
            }
        }
        if (json.has("term")) {
            if (json.isNull("term")) {
                objProxy.realmSet$term(null);
            } else {
                objProxy.realmSet$term((String) json.getString("term"));
            }
        }
        if (json.has("year")) {
            if (json.isNull("year")) {
                objProxy.realmSet$year(null);
            } else {
                objProxy.realmSet$year((String) json.getString("year"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("createdDate")) {
            if (json.isNull("createdDate")) {
                objProxy.realmSet$createdDate(null);
            } else {
                objProxy.realmSet$createdDate((String) json.getString("createdDate"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.fitzafful.gliveportal.db.Bill createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.fitzafful.gliveportal.db.Bill obj = new com.fitzafful.gliveportal.db.Bill();
        final BillRealmProxyInterface objProxy = (BillRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("bill_name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bill_name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$bill_name(null);
                }
            } else if (name.equals("amount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$amount((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$amount(null);
                }
            } else if (name.equals("credit")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$credit((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$credit(null);
                }
            } else if (name.equals("term")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$term((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$term(null);
                }
            } else if (name.equals("year")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$year((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$year(null);
                }
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
                }
            } else if (name.equals("createdDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$createdDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$createdDate(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.fitzafful.gliveportal.db.Bill copyOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Bill object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Bill) cachedRealmObject;
        }

        com.fitzafful.gliveportal.db.Bill realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Bill.class);
            BillColumnInfo columnInfo = (BillColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Bill.class);
            long pkColumnIndex = columnInfo.idIndex;
            Number value = ((BillRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Bill.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.BillRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.fitzafful.gliveportal.db.Bill copy(Realm realm, com.fitzafful.gliveportal.db.Bill newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Bill) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.fitzafful.gliveportal.db.Bill realmObject = realm.createObjectInternal(com.fitzafful.gliveportal.db.Bill.class, ((BillRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        BillRealmProxyInterface realmObjectSource = (BillRealmProxyInterface) newObject;
        BillRealmProxyInterface realmObjectCopy = (BillRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$bill_name(realmObjectSource.realmGet$bill_name());
        realmObjectCopy.realmSet$amount(realmObjectSource.realmGet$amount());
        realmObjectCopy.realmSet$credit(realmObjectSource.realmGet$credit());
        realmObjectCopy.realmSet$term(realmObjectSource.realmGet$term());
        realmObjectCopy.realmSet$year(realmObjectSource.realmGet$year());
        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$createdDate(realmObjectSource.realmGet$createdDate());
        return realmObject;
    }

    public static long insert(Realm realm, com.fitzafful.gliveportal.db.Bill object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Bill.class);
        long tableNativePtr = table.getNativePtr();
        BillColumnInfo columnInfo = (BillColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Bill.class);
        long pkColumnIndex = columnInfo.idIndex;
        Object primaryKeyValue = ((BillRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((BillRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((BillRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$bill_name = ((BillRealmProxyInterface) object).realmGet$bill_name();
        if (realmGet$bill_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bill_nameIndex, rowIndex, realmGet$bill_name, false);
        }
        String realmGet$amount = ((BillRealmProxyInterface) object).realmGet$amount();
        if (realmGet$amount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.amountIndex, rowIndex, realmGet$amount, false);
        }
        String realmGet$credit = ((BillRealmProxyInterface) object).realmGet$credit();
        if (realmGet$credit != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.creditIndex, rowIndex, realmGet$credit, false);
        }
        String realmGet$term = ((BillRealmProxyInterface) object).realmGet$term();
        if (realmGet$term != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.termIndex, rowIndex, realmGet$term, false);
        }
        String realmGet$year = ((BillRealmProxyInterface) object).realmGet$year();
        if (realmGet$year != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.yearIndex, rowIndex, realmGet$year, false);
        }
        String realmGet$type = ((BillRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        String realmGet$createdDate = ((BillRealmProxyInterface) object).realmGet$createdDate();
        if (realmGet$createdDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdDateIndex, rowIndex, realmGet$createdDate, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Bill.class);
        long tableNativePtr = table.getNativePtr();
        BillColumnInfo columnInfo = (BillColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Bill.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Bill object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Bill) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            Object primaryKeyValue = ((BillRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((BillRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((BillRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$bill_name = ((BillRealmProxyInterface) object).realmGet$bill_name();
            if (realmGet$bill_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bill_nameIndex, rowIndex, realmGet$bill_name, false);
            }
            String realmGet$amount = ((BillRealmProxyInterface) object).realmGet$amount();
            if (realmGet$amount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.amountIndex, rowIndex, realmGet$amount, false);
            }
            String realmGet$credit = ((BillRealmProxyInterface) object).realmGet$credit();
            if (realmGet$credit != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.creditIndex, rowIndex, realmGet$credit, false);
            }
            String realmGet$term = ((BillRealmProxyInterface) object).realmGet$term();
            if (realmGet$term != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.termIndex, rowIndex, realmGet$term, false);
            }
            String realmGet$year = ((BillRealmProxyInterface) object).realmGet$year();
            if (realmGet$year != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.yearIndex, rowIndex, realmGet$year, false);
            }
            String realmGet$type = ((BillRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }
            String realmGet$createdDate = ((BillRealmProxyInterface) object).realmGet$createdDate();
            if (realmGet$createdDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdDateIndex, rowIndex, realmGet$createdDate, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Bill object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Bill.class);
        long tableNativePtr = table.getNativePtr();
        BillColumnInfo columnInfo = (BillColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Bill.class);
        long pkColumnIndex = columnInfo.idIndex;
        Object primaryKeyValue = ((BillRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((BillRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((BillRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$bill_name = ((BillRealmProxyInterface) object).realmGet$bill_name();
        if (realmGet$bill_name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.bill_nameIndex, rowIndex, realmGet$bill_name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bill_nameIndex, rowIndex, false);
        }
        String realmGet$amount = ((BillRealmProxyInterface) object).realmGet$amount();
        if (realmGet$amount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.amountIndex, rowIndex, realmGet$amount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.amountIndex, rowIndex, false);
        }
        String realmGet$credit = ((BillRealmProxyInterface) object).realmGet$credit();
        if (realmGet$credit != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.creditIndex, rowIndex, realmGet$credit, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.creditIndex, rowIndex, false);
        }
        String realmGet$term = ((BillRealmProxyInterface) object).realmGet$term();
        if (realmGet$term != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.termIndex, rowIndex, realmGet$term, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.termIndex, rowIndex, false);
        }
        String realmGet$year = ((BillRealmProxyInterface) object).realmGet$year();
        if (realmGet$year != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.yearIndex, rowIndex, realmGet$year, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.yearIndex, rowIndex, false);
        }
        String realmGet$type = ((BillRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        String realmGet$createdDate = ((BillRealmProxyInterface) object).realmGet$createdDate();
        if (realmGet$createdDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdDateIndex, rowIndex, realmGet$createdDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdDateIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Bill.class);
        long tableNativePtr = table.getNativePtr();
        BillColumnInfo columnInfo = (BillColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Bill.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Bill object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Bill) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            Object primaryKeyValue = ((BillRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((BillRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((BillRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$bill_name = ((BillRealmProxyInterface) object).realmGet$bill_name();
            if (realmGet$bill_name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.bill_nameIndex, rowIndex, realmGet$bill_name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.bill_nameIndex, rowIndex, false);
            }
            String realmGet$amount = ((BillRealmProxyInterface) object).realmGet$amount();
            if (realmGet$amount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.amountIndex, rowIndex, realmGet$amount, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.amountIndex, rowIndex, false);
            }
            String realmGet$credit = ((BillRealmProxyInterface) object).realmGet$credit();
            if (realmGet$credit != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.creditIndex, rowIndex, realmGet$credit, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.creditIndex, rowIndex, false);
            }
            String realmGet$term = ((BillRealmProxyInterface) object).realmGet$term();
            if (realmGet$term != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.termIndex, rowIndex, realmGet$term, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.termIndex, rowIndex, false);
            }
            String realmGet$year = ((BillRealmProxyInterface) object).realmGet$year();
            if (realmGet$year != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.yearIndex, rowIndex, realmGet$year, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.yearIndex, rowIndex, false);
            }
            String realmGet$type = ((BillRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }
            String realmGet$createdDate = ((BillRealmProxyInterface) object).realmGet$createdDate();
            if (realmGet$createdDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdDateIndex, rowIndex, realmGet$createdDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdDateIndex, rowIndex, false);
            }
        }
    }

    public static com.fitzafful.gliveportal.db.Bill createDetachedCopy(com.fitzafful.gliveportal.db.Bill realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.fitzafful.gliveportal.db.Bill unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.fitzafful.gliveportal.db.Bill();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.fitzafful.gliveportal.db.Bill) cachedObject.object;
            }
            unmanagedObject = (com.fitzafful.gliveportal.db.Bill) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        BillRealmProxyInterface unmanagedCopy = (BillRealmProxyInterface) unmanagedObject;
        BillRealmProxyInterface realmSource = (BillRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$bill_name(realmSource.realmGet$bill_name());
        unmanagedCopy.realmSet$amount(realmSource.realmGet$amount());
        unmanagedCopy.realmSet$credit(realmSource.realmGet$credit());
        unmanagedCopy.realmSet$term(realmSource.realmGet$term());
        unmanagedCopy.realmSet$year(realmSource.realmGet$year());
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$createdDate(realmSource.realmGet$createdDate());

        return unmanagedObject;
    }

    static com.fitzafful.gliveportal.db.Bill update(Realm realm, com.fitzafful.gliveportal.db.Bill realmObject, com.fitzafful.gliveportal.db.Bill newObject, Map<RealmModel, RealmObjectProxy> cache) {
        BillRealmProxyInterface realmObjectTarget = (BillRealmProxyInterface) realmObject;
        BillRealmProxyInterface realmObjectSource = (BillRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$bill_name(realmObjectSource.realmGet$bill_name());
        realmObjectTarget.realmSet$amount(realmObjectSource.realmGet$amount());
        realmObjectTarget.realmSet$credit(realmObjectSource.realmGet$credit());
        realmObjectTarget.realmSet$term(realmObjectSource.realmGet$term());
        realmObjectTarget.realmSet$year(realmObjectSource.realmGet$year());
        realmObjectTarget.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectTarget.realmSet$createdDate(realmObjectSource.realmGet$createdDate());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Bill = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bill_name:");
        stringBuilder.append(realmGet$bill_name() != null ? realmGet$bill_name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{amount:");
        stringBuilder.append(realmGet$amount() != null ? realmGet$amount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{credit:");
        stringBuilder.append(realmGet$credit() != null ? realmGet$credit() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{term:");
        stringBuilder.append(realmGet$term() != null ? realmGet$term() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{year:");
        stringBuilder.append(realmGet$year() != null ? realmGet$year() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdDate:");
        stringBuilder.append(realmGet$createdDate() != null ? realmGet$createdDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillRealmProxy aBill = (BillRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBill.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBill.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBill.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
